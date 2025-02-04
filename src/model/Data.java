package model;

import exceptii.AnNeadecvat;
import exceptii.FormatException;
import exceptii.LunaNeadecvata;
import exceptii.ZiNeadecvata;

import java.util.Scanner;
import java.util.Optional;

public class Data implements Comparable<Data> {
    private int zi;
    private Luna luna;
    private int an;

    public Data(int z, Luna l, int a) throws Exception{
        Optional<Exception> obj = buildException(z,l.getNrOrdine(),a);
        if(obj.isEmpty()) {
            this.zi = z;
            this.luna = l;
            this.an = a;
        }
        else{
            throw obj.get();
        }
    }

    public Data(int z, int l, int a) throws Exception{
        Optional<Exception> obj = buildException(z,l,a);
        if(obj.isEmpty()) {
            this.zi = z;
            this.luna = Luna.getLuna(l);
            this.an = a;
        }
        else{
            throw obj.get();
        }
    }

    public Data(String linie) throws Exception{
        if(RegularExpresion.RegularExpresionData(linie) == false) {
            FormatException fn = new FormatException(linie, FormatException.DATA_FORMAT);
             throw fn;
        }
        Scanner scanner = new Scanner(linie);
        scanner.useDelimiter("/");
        int z = scanner.nextInt();
        int l = scanner.nextInt();
        int an = scanner.nextInt();
        Optional<Exception> obj = buildException(z,l,an);
        if(obj.isEmpty()){
            this.zi = z;
            this.luna = Luna.getLuna(l);
            this.an = an;
        }
        else {
            throw obj.get();
        }
        scanner.close();
    }

    public int getZi() {
        return zi;
    }

    public Luna getLuna() {
        return luna;
    }

    public int getAn() {
        return an;
    }

    @Override
    public String toString() {
        return "model.Data [zi=" + zi + ", luna=" + luna + ", an=" + an + "]";
    }

    public boolean equals(Object obj){
        if(obj == null){
            return false;
        }
        if(obj instanceof Data){
            Data d = (Data)obj;
            if(this.zi == d.zi && this.luna == d.luna && this.an == d.an){
                return true;
            }
        }
        return false;
    }

    public int diferenta(Data d1){
        int nrZileAni = (366 * (this.an / 4)) + ((this.an - (this.an / 4)) * 365);
        int nrZileScurseAnCurent = 0;
        for(int i = 1; i < this.luna.getNrOrdine(); i++){
            nrZileScurseAnCurent += Luna.getLuna(i).getNrZile()[0];
        }
        if(this.an % 4 == 0){
            nrZileScurseAnCurent++;
        }
        int nrTotalZile1 = this.zi + nrZileAni + nrZileScurseAnCurent;

        int nrZileAni2 = (366 * (d1.an / 4)) + ((d1.an - (d1.an / 4)) * 365);
        int nrZileScurseAnCurent2 = 0;
        for(int i = 1; i < d1.luna.getNrOrdine(); i++){
            nrZileScurseAnCurent2 += Luna.getLuna(i).getNrZile()[0];
        }
        if(d1.an % 4 == 0){
            nrZileScurseAnCurent2++;
        }
        int nrTotalZile2 = d1.zi + nrZileAni2 + nrZileScurseAnCurent2;
        return nrTotalZile2 > nrTotalZile1 ? (nrTotalZile2 - nrTotalZile1) + 1 : (nrTotalZile1 - nrTotalZile2) + 1;
    }

    private Optional<Exception> buildException(int z, int l, int a){
        Optional<Exception> obj = Optional.empty();
        if(z < 0 ){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.NEGATIV,z);
            obj = Optional.of(zin);
            return obj;
        }
        else if(z == 0){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.NULA,z);
            obj = Optional.of(zin);
            return obj;
        }
        else if(z > 28 && l == 2 && a % 4 != 0){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.GREATER_THAN_28,z);
            obj = Optional.of(zin);
            return obj;
        }
        else if(z > 29 && l == 2 && a % 4 == 0){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.GREATER_THAN_29,z);
            obj = Optional.of(zin);
            return obj;
        }
        else if(z > 30 && (l == 4 || l == 6 || l == 9 || l == 11)){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.GREATER_THAN_30,z);
            obj = Optional.of(zin);
            return obj;
        }
        else if(z > 31 && (l == 1 || l == 3 || l == 5 || l == 7 || l == 8 || l == 10 || l == 12)){
            ZiNeadecvata zin = new ZiNeadecvata(ZiNeadecvata.GREATER_THAN_31,z);
            obj = Optional.of(zin);
            return obj;
        }
        if(l < 1 || l > 12){
            LunaNeadecvata ln = new LunaNeadecvata(l);
            obj = Optional.of(ln);
            return obj;
        }
        if(a < 1924 || a > AnNeadecvat.extrageAn()){
            AnNeadecvat anN = new AnNeadecvat(a);
            obj = Optional.of(anN);
            return obj;
        }
        return obj;
    } // end buildException function

    public int compareTo(Data d){
        if(this.an > d.an){
            return 1;
        }
        else if(this.an < d.an){
            return -1;
        }
        else if(this.an == d.an){
            if(this.luna.getNrOrdine() > d.luna.getNrOrdine()){
                return 1;
            }
            else if(this.luna.getNrOrdine() < d.luna.getNrOrdine()){
                return -1;
            }
            else if(this.luna.getNrOrdine() == d.luna.getNrOrdine()){
                if(this.zi > d.zi){
                    return 1;
                }
                else if(this.zi < d.zi){
                    return -1;
                }
                else if(this.zi == d.zi){
                    return 0;
                }
            }
        }
        return 0;
    }
} // end class
