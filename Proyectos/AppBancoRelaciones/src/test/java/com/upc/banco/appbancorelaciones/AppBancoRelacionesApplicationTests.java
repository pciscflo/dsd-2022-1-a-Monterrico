package com.upc.banco.appbancorelaciones;

import com.upc.banco.appbancorelaciones.entidades.Cliente;
import com.upc.banco.appbancorelaciones.entidades.Cuenta;
import com.upc.banco.appbancorelaciones.entidades.Operacion;
import com.upc.banco.appbancorelaciones.entidades.TipoOperacion;
import com.upc.banco.appbancorelaciones.repositorio.ClienteRepositorio;
import com.upc.banco.appbancorelaciones.repositorio.CuentaRepositorio;
import com.upc.banco.appbancorelaciones.repositorio.OperacionRepositorio;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class AppBancoRelacionesApplicationTests {
    @Autowired
    OperacionRepositorio operacionRepositorio;
    @Autowired
    CuentaRepositorio cuentaRepositorio;
    @Autowired
    ClienteRepositorio clienteRepositorio;



    //@Test
    public void pruebaOperaciones() {
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        Operacion operacion = new Operacion();
        operacion.setMonto(77D);
        operacion.setNumeroCuentaDeposito(1111111111L);
        operacion.setNumeroCuentaRetiro(2222222222L);
        TipoOperacion tipoOperacion = new TipoOperacion();
        tipoOperacion.setIdTipo(3L);
        operacion.setTipoOperacion(tipoOperacion);
        operacion.setCliente(cliente);
        Operacion resultado = operacionRepositorio.save(operacion);
        Assert.assertEquals(resultado, operacion);
    }

    //@Test
    public void pruebaValidaciones() {
        Cuenta cuenta  = cuentaRepositorio.verificarNumeroCuenta(1111111111L);
        System.out.println(cuenta.getSaldo());
        Assert.assertNotNull(cuenta);
        cuenta = cuentaRepositorio.verificarCuentaSaldo(1111111111L, 30D);
        System.out.println(cuenta);
        Assert.assertNotNull(cuenta);	   //si tiene saldo, es su cuenta de id
    }
    //@Test
    public void pruebaActualizarSaldo() {
        Cuenta cuenta =  cuentaRepositorio.verificarNumeroCuenta(1111111111L);
        //abonamos a su saldo
        cuenta.setSaldo(cuenta.getSaldo() + 10);
        //registramos operacion
        cuentaRepositorio.save(cuenta);
    }
    //@Test
    public void pruebaEliminarOp() {
        Operacion operacion = new Operacion();
        operacion.setIdOperacion(1L);
        operacionRepositorio.delete(operacion);
    }
    @Test
    public void grabarCliente() {
        Cliente cliente = new Cliente();
        cliente.setClave("8888");
        cliente.setDni("88888888");
        cliente.setNombre("Carlos");
        clienteRepositorio.save(cliente);
    }
    //@Test
    public void grabaCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setNumeroCuenta(4444444444L);
        cuenta.setSaldo(2000D);
        //puedo obviar a que cliente pertenece
        Cliente cliente = new Cliente();
        cliente.setIdCliente(1L);
        cuenta.setCliente(cliente);
        cuentaRepositorio.save(cuenta);
    }
    //@Test
    public void pruebaValidaIdCuentaSaldo() {
        Cuenta cuenta = cuentaRepositorio.verificaIdCuentaSaldo(1L,1111111111L,10D);
        System.out.println(cuenta.getSaldo());
        Assert.assertNotNull(cuenta);

    }
    @Test
    public void obtenerCuentasDeCliente() {
        List<Cuenta> cuentas = clienteRepositorio.obtenerCliente("88888888").getCuentas();
        Assert.assertNotNull(cuentas);
    }

}
