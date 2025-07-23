import java.util.ArrayList;
import java.util.List;

public class TaxSlabs {
    static class Entry {
        public Entry(int start, int end, int rate) {
            this.start = start;
            this.end = end;
            this.rate = rate;
        }
        int start;
        int end;
        int rate;
    }

    List<Entry> ftbSlabs =  new ArrayList<>();
    List<Entry> normalSlabs =  new ArrayList<>();

    TaxSlabs(){
        ftbSlabs.add(new Entry(0, 250_000, 0));
        ftbSlabs.add(new Entry(250_000, 500_000, 2));
        ftbSlabs.add(new Entry(500_000, 1_000_000, 5));
        ftbSlabs.add(new Entry(1_000_000, 1_500_000, 8));
        ftbSlabs.add(new Entry(1_500_000, Integer.MAX_VALUE, 12));

        normalSlabs.add(new Entry(0, 125_000, 0));
        normalSlabs.add(new Entry(125_000, 250_000, 2));
        normalSlabs.add(new Entry(250_000, 600_000, 5));
        normalSlabs.add(new Entry(600_000, 1_000_000, 8));
        normalSlabs.add(new Entry(1_000_000, 2_000_000, 12));
        normalSlabs.add(new Entry(2_000_000, Integer.MAX_VALUE, 20));
    }

    double calculateTax(double X, List<Entry> slabs){

        double tax = 0.0;
        for(Entry slab : slabs){
            double AmountToTax = Math.min(X, slab.end - slab.start - 1);
            tax += AmountToTax * slab.rate/100;
            X -= AmountToTax;
            if ( X == 0.0)
                break;
        }
        return tax;
    }

    public static void main(String[] args) {
        TaxSlabs ts = new TaxSlabs();
        double tax = ts.calculateTax(500_000, ts.ftbSlabs);
        System.out.println(tax);
    }

}
