import java.util.List;
import java.util.stream.Collectors;

public class FilterString {

    public static List<Object> filterList(final List<Object> list) {
        return list.stream().filter(a -> !(a instanceof String)).collect(Collectors.toList());
    }
}
