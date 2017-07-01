import java.util.ArrayList;
import java.util.Arrays;

class Node {

    private String name = null;
    private ArrayList<Node> childNodes = null;

    Node( String name ) {
        this.name = name;
        childNodes = new ArrayList<>();
    }

    Node withChildren( Node[] children ) {
        childNodes.addAll( Arrays.asList( children ) );
        return this;
    }

    void addNode( Node n ) {
        childNodes.add( n );
    }

    ArrayList<Node> getChildNodes() {
        return childNodes;
    }

    String getName() {
        return name;
    }
}