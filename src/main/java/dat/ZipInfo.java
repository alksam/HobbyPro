package dat;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ZipInfo {

    private int zip;
    private String name;

    public ZipInfo(int zip, String name) {
        this.zip = zip;
        this.name = name;
    }

    public int getZip() {
        return zip;
    }

    public String getName() {
        return name;
    }
}
