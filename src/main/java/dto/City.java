package dto;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "zipcode")
@Getter
@Setter
@NoArgsConstructor
@ToString
@NamedQueries({
        @NamedQuery(name = "City.getAll", query = "SELECT c FROM City c"),
        @NamedQuery(name = "City.getByZip", query = "SELECT c FROM City c WHERE c.zip = :zip")
})
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "zip")
    private int zip;
    @Column(name = "city_name")
    private String city_name;
    @Column(name = "region_name")
    private String region_name;
    @Column(name = "municipality_name")
    private String municipality_name;

    @OneToMany(fetch = FetchType.EAGER,mappedBy = "city", cascade = CascadeType.MERGE)
    Set<Address> addresses = new HashSet<>();


    public City(int zip, String city_name, String region_name, String municipality_name) {
        this.zip = zip;
        this.city_name = city_name;
        this.region_name = region_name;
        this.municipality_name = municipality_name;
    }

}
