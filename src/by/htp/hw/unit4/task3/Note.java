package by.htp.hw.unit4.task3;

public class Note {

    private String name;
    private String country;
    private String telephone;

    public Note(String name, String country, String telephone) {
        this.name = name;
        this.country = country;
        this.telephone = telephone;
    }

    public String getName() {
        return name;
    }

    public String getCountry() {
        return country;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }


    public Note findNote(String line) {
        if (this.name.equals(line) || this.country.equals(line) || this.telephone.equals(line))
            return this;
        else return null;
    }

    @Override
    public String toString() {
        return "Note{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
