public class SortedList<T extends Comparable<T>> implements ISortedList<T> {

    private Nodo<T> cabeza;
    private int size;

    public SortedList() {
        this.cabeza = null;
        this.size = 0;
    }

    @Override
    public void insert(T elem) {
        if (elem == null) {
            return;
        }

        Nodo<T> nuevo = new Nodo<>(elem);

        if (isEmpty()) {
            cabeza = nuevo;
        } else {
            Nodo<T> actual = cabeza;
            Nodo<T> anterior = null;

            while (actual != null && actual.getDato().compareTo(elem) < 0) {
                anterior = actual;
                actual = actual.getSiguiente();
            }

            if (actual == null) { // Insertar al final
                anterior.setSiguiente(nuevo);
            } else if (actual.getDato().compareTo(elem) == 0) { // Elemento ya existe
                return;
            } else { // Insertar en medio
                if (anterior == null) { // Insertar al principio
                    cabeza = nuevo;
                } else {
                    anterior.setSiguiente(nuevo);
                }
                nuevo.setSiguiente(actual);
            }
        }

        size++;
    }

    @Override
    public boolean delete(T elem) {
        if (elem == null || isEmpty()) {
            return false;
        }

        Nodo<T> actual = cabeza;
        Nodo<T> anterior = null;

        while (actual != null && actual.getDato().compareTo(elem) < 0) {
            anterior = actual;
            actual = actual.getSiguiente();
        }

        if (actual == null) { // Elemento no encontrado
            return false;
        }

        if (anterior == null) { // Eliminar al principio
            cabeza = cabeza.getSiguiente();
        } else {
            anterior.setSiguiente(actual.getSiguiente());
        }

        size--;
        return true;
    }

    @Override
    public boolean search(T elem) {
        if (elem == null || isEmpty()) {
            return false;
        }

        Nodo<T> actual = cabeza;

        while (actual != null && actual.getDato().compareTo(elem) < 0) {
            actual = actual.getSiguiente();
        }

        return actual != null && actual.getDato().compareTo(elem) == 0;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }

        StringBuilder sb = new StringBuilder("[");
        Nodo<T> actual = cabeza;

        while (actual != null) {
            sb.append(actual.getDato()).append(", ");
            actual = actual.getSiguiente();
        }

        sb.deleteCharAt(sb.length() - 1);
        sb.deleteCharAt(sb.length() - 1);
        sb.append("]");

        return sb.toString();
    }
}