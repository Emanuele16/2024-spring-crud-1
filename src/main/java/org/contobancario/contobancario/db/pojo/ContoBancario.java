package org.contobancario.contobancario.db.pojo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContoBancario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int saldo;

    public ContoBancario() {
        this.saldo = 0;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSaldo() {
        return saldo;
    }

    public void deposita(int importo) throws IllegalArgumentException {
        if (importo < 0) {
            throw new IllegalArgumentException("L'importo da depositare non può essere negativo.");
        }
        saldo += importo;
    }

    public void preleva(int importo) throws IllegalArgumentException, IllegalStateException {
        if (importo < 0) {
            throw new IllegalArgumentException("L'importo da prelevare non può essere negativo.");
        }
        if (importo > saldo) {
            throw new IllegalStateException("Saldo insufficiente per il prelievo richiesto.");
        }
        saldo -= importo;
    }

    @Override
    public String toString() {
        return "ContoBancario:[id = " + id + ", saldo = " + saldo + "]";
    }
}