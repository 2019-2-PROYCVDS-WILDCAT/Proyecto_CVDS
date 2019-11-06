
import edu.eci.cvds.samples.entities.Recurso;
import java.util.Comparator;
import javax.swing.SortOrder;

public class RecursoSorter implements Comparator<Recurso> {
 
    private String sortField;
     
    private SortOrder sortOrder;
     
    public RecursoSorter(String sortField, SortOrder sortOrder) {
        this.sortField = sortField;
        this.sortOrder = sortOrder;
    }
    
    @Override
    public int compare(Recurso car1, Recurso car2) {
        try {
            Object value1 = Recurso.class.getField(this.sortField).get(car1);
            Object value2 = Recurso.class.getField(this.sortField).get(car2);
 
            int value = ((Comparable)value1).compareTo(value2);
             
            return SortOrder.ASCENDING.equals(sortOrder) ? value : -1 * value;
        }
        catch(Exception e) {
            throw new RuntimeException();
        }
    }
}