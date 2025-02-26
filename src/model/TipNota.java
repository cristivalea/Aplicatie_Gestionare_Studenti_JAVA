package model;

public enum TipNota {
    N("Nota numerica"),
    C("Calificativ"),
    A("Admis / Respins");

    private String denumire;

    TipNota(String denumire) {
        this.denumire = denumire;
    }

    public String getDenumire() {
        return denumire;
    }
}
