package pl.akademiakodu.giflib.model;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Camillo on 19.11.2016.
 */

@Entity
@Table(name="OMG_CRAZY_TABEL")
public class PrzykałdaowaKlasa {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name= "GO",nullable = false)
    private String columneA;
    @Column(name= "AND",columnDefinition = "CLOB NOT NULL")
    private String columneB;
    @Column(name= "DEBUG",unique = true)
    private String columneC;
    @Column(name= "THIS",precision = 12)
    private BigDecimal columneD;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getColumneA() {
        return columneA;
    }

    public void setColumneA(String columneA) {
        this.columneA = columneA;
    }

    public String getColumneB() {
        return columneB;
    }

    public void setColumneB(String columneB) {
        this.columneB = columneB;
    }

    public String getColumneC() {
        return columneC;
    }

    public void setColumneC(String columneC) {
        this.columneC = columneC;
    }

    public BigDecimal getColumneD() {
        return columneD;
    }

    public void setColumneD(BigDecimal columneD) {
        this.columneD = columneD;
    }
}
