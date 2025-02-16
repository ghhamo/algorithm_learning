package job;

public class STMain {
    public static void main(String[] args) {
        OST<String, Integer> st = new OST<>(15);
        st.insert("s", 17);
        st.insert("m", 13);
        st.insert("a", 0);
        st.insert("c", 2);
        st.insert("b", 11);
        System.out.println(st.scan("a"));
        System.out.println(st.scan("w"));
        st.insert("d", 3);
        st.insert("b", 1);
        st.insert("n", 12);
        st.insert("e", 4);
        st.insert("f", 5);
        System.out.println(st.scan("b"));
        st.insert("h", 16);
        st.insert("h", 7);
        st.insert("g", 9);
        st.insert("c", 10);
        st.insert("i", 8);
        st.insert("i", 14);
        st.insert("u", 15);
        st.insert("g", 6);
        System.out.println(st.scan("q"));
        System.out.println(st.scan("a"));
        System.out.println(st.scan("e"));
        System.out.println(st.scan("u"));
        System.out.println(st.scan("m"));
    }
}