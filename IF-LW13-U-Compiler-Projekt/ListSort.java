public class ListSort {
    public static void main(String[] args) {
        List list = new List();
        list.append(1);
        list.append(3);
        list.append(4);
        printList(list);
        insertSorted(list, 2);
        insertSorted(list, 5);
        insertSorted(list, 0);
        printList(list);
    }
    
    public static void insertSorted(List list, int value) {
        boolean inserted = false;
        list.toFirst();
        while (list.hasAccess()) {
            if (list.getContent() > value) {
                list.insert(value);
                inserted = true;
                return;
            }
            list.next();   
        }
        if (!inserted) {
            list.append(value);
        }
        list.toFirst();
    }

    public static void printList(List list) {
        list.toFirst();
        while (list.hasAccess()) {
            System.out.println(list.getContent());
            list.next();
        }
        list.toFirst();
    }
}