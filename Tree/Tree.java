
/**
 * A simple proof of implementation and proof of concept of the 'Tree' data 
 * structure.
 * 
 * @author Aniruddha Deb
 */
public class Tree {

    public static void main( String[] args ) {

        Node parentNode = 
        new Node( "Parent" ).withChildren( new Node[]{ 
            new Node( "Child 1" ).withChildren( new Node[]{ 
                new Node( "GrandChild 1" ),
                new Node( "GrandChild 2" ).withChildren( new Node[]{
                    new Node( "GreatGrandChild 1" )
                } )                
            } ),
            new Node( "Child 2" ).withChildren( new Node[]{ 
                new Node( "Grandchild 3" )
            } )
        } );

        printAllNodes( parentNode );
    }

    static int recLev = 0;

    static void printAllNodes( Node parentNode ) {

        for( int i=0; i<recLev; i++ ) {
            System.out.print( "\t" );
        }
        System.out.println( parentNode.getName() );

        recLev++;
        for( Node n : parentNode.getChildNodes() ) {
            printAllNodes( n );
        }
        recLev--;
    }
}