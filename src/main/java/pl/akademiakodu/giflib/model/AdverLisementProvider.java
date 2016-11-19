package pl.akademiakodu.giflib.model;

import javax.persistence.*;

/**
 * Created by Camillo on 19.11.2016.
 */
@Entity
@Table(name="ADS_PROV")
public class AdverLisementProvider {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    @Column(name= "name",unique = true)
    private String companyName;

    @Column(name= "desc",nullable = false)
    private String descryption;

    @Column(name= "created",nullable = true)
    private int yearCreated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCompanyNme() {
        return companyName;
    }

    public void setCompanyNme(String companyNme) {
        this.companyName = companyNme;
    }

    public String getDescryption() {
        return descryption;
    }

    public void setDescryption(String descryption) {
        this.descryption = descryption;
    }

    public int getYearCreated() {
        return yearCreated;
    }

    public void setYearCreated(int yearCreated) {
        this.yearCreated = yearCreated;
    }

    @Override
    public String toString() {
        return "AdverLisementProvider{" +
                "id=" + id +
                ", companyName='" + companyName + '\'' +
                ", descryption='" + descryption + '\'' +
                ", yearCreated=" + yearCreated +
                '}';
    }
}
