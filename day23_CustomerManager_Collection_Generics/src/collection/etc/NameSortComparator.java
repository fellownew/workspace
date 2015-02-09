package collection.etc;

import java.util.Comparator;
import collection.vo.Customer;

public class NameSortComparator implements Comparator<Customer> {
	@Override
	public int compare(Customer o1, Customer o2) {
		return o2.getName().compareTo(o1.getName());
	}
}
