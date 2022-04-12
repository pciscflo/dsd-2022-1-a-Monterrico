package com.upc.banco.appbancorelaciones.negocio;

import com.upc.banco.appbancorelaciones.entidades.Cliente;
import com.upc.banco.appbancorelaciones.entidades.Cuenta;
import com.upc.banco.appbancorelaciones.entidades.Operacion;
import com.upc.banco.appbancorelaciones.repositorio.ClienteRepositorio;
import com.upc.banco.appbancorelaciones.repositorio.CuentaRepositorio;
import com.upc.banco.appbancorelaciones.repositorio.OperacionRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class NegocioOperaciones {

	@Autowired
	private CuentaRepositorio cuentaRepositorio;
	@Autowired
	private ClienteRepositorio clienteRepositorio;
	@Autowired
	private OperacionRepositorio operacionRepositorio;

	@Transactional(propagation=Propagation.REQUIRED)
	public Operacion deposito(Operacion operacion) {
		Operacion operacionRespuesta = new Operacion();
		try {
			// verificamos si cliente existe por id
			Cliente cliente = clienteRepositorio.findById(operacion.getCliente().getIdCliente()).get();
			if (cliente != null) {
				// verificamos si numero de cuenta deposito existe
				Cuenta cuenta = cuentaRepositorio.verificarNumeroCuenta(operacion.getNumeroCuentaDeposito());
				if (cuenta != null) {
					//sumanos a su saldo
					cuenta.setSaldo(cuenta.getSaldo() + operacion.getMonto());
					// actualizamos nuevo saldo
					cuentaRepositorio.save(cuenta);
					// registramos operacion
					cliente.setCuentas(null); // para evitar la recursividad de JSON
					operacion.setCliente(cliente);
					operacion.setRespuesta("Ok");
					operacionRespuesta = operacionRepositorio.save(operacion);
				}else {
					operacionRespuesta.setRespuesta("Cuenta depósito no existe");
				}
			} else {
				operacionRespuesta.setRespuesta("Cliente no existe");
			}
		} catch (Exception e) {

			operacion.setRespuesta("Error:No se realizó la operación");
		}
		return operacionRespuesta;
	}

	/**
	 * Transfiere monto considerando una validaciond e cliente, saldo y cuenta de
	 * retiro en un query Trama Json input:
	 * 
	 * @param operacion
	 * @return
	 */
	@Transactional
	public Operacion transferencia(Operacion operacion) {
		// verificamos si la cuenta retiro es cuenta de idCliente y si tiene saldo
		Cuenta cuentaRetiro = cuentaRepositorio.verificaIdCuentaSaldo(operacion.getCliente().getIdCliente(),
				operacion.getNumeroCuentaRetiro(), operacion.getMonto());
		Operacion operacionRespuesta = new Operacion();
		if (operacion.getTipoOperacion().getIdTipo() == 3) {
			if (cuentaRetiro != null) {
				if (cuentaRetiro.getSaldo() >= operacion.getMonto()) {
					// verificamos si existe cuenta deposito
					Cuenta cuentaDeposito = cuentaRepositorio.verificarNumeroCuenta(operacion.getNumeroCuentaDeposito());
					if (cuentaDeposito != null) {
						// procedemos descontamos monto del saldo de cuenta origen
						cuentaRetiro.setSaldo(cuentaRetiro.getSaldo() - operacion.getMonto());
						cuentaRepositorio.save(cuentaRetiro);
						// sumamos monto al saldo de la cuenta deposito
						cuentaDeposito.setSaldo(cuentaDeposito.getSaldo() + operacion.getMonto());
						cuentaRepositorio.save(cuentaDeposito);
						operacionRespuesta = operacionRepositorio.save(operacion);
					} else {
						operacionRespuesta.setRespuesta("Cuenta de Depósito no existe");
					}
				}
			} else {
				operacionRespuesta.setRespuesta("Cuenta de Retiro no autorizada");
			}
		} else {
			operacionRespuesta.setRespuesta("Tipo de Operación no permitida");
		}
		return operacionRespuesta;
	}

		public void retiro(Long idCliente, Long numeroCuentaRetiro, Double monto) {
		// verificamos si es su cuenta y tiene saldo

		// debitamos el monto de su cuenta

		// registramos operacion

	}

}
