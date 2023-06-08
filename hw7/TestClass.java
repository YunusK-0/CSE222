public class TestClass
{
    public static void main(String[] args) {
        String input = "'Hush, hush!' whispered the rushing wind.";//"a bb ccc dddd eeeee ffffff ggggggg hhhhhhhh iiiiiiiii xxxxxxxxxx";
        System.out.println("Original string is "+ input);
        myMap yunus = new myMap(input);
        //TestBuble(yunus);
        //TestInsertion(yunus);
        //TestSelection(yunus);
        Testquick(yunus);
        //TestMerge(yunus);
    }
    public static void TestBuble(myMap yunus)
    {
        long run1=System.nanoTime();
        BubbleSort test = new BubbleSort(yunus);
        test.bublesort();
        long run2= System.nanoTime();
        System.out.println((run2-run1)/1000000 +" millisecond time required");
        System.out.println(" BUBLE SORT!!!!!!!!!!!!!!!!!!! best case is done!!!!");
        myMap worst = new myMap("xxxxxxxxxx iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a");
        test= new BubbleSort(worst);
        test.bublesort();
        long run3 = System.nanoTime();
        System.out.println((run3-run2)/1000000 +" millisecond time required");
        System.out.println(" BUBLE SORT!!!! Worst Case is done!!!!");

        myMap avarage = new myMap("eeeee ffffff a hhhhhhhh dddd ccc iiiiiiiii bb xxxxxxxxxx ");
        test = new BubbleSort(avarage);
        test.bublesort();
        
        long run4 = System.nanoTime();
        System.out.println((run4-run3)/1000000 +" millisecond time required");
        System.out.println("BUBLE SORT-------------------Avarage case is don-------------");
    }
    public static void TestInsertion(myMap yunus)
    {
        long run1=System.nanoTime();
        insertionsort test = new insertionsort(yunus);
        test.insertionsort();
        long run2= System.nanoTime();
        System.out.println((run2-run1)/1000000 +" millisecond time required");
        System.out.println(" INSERTION SORT--!!!!!!!!!!!!!!!!!!! best case is done!!!!");
        myMap worst = new myMap("xxxxxxxxxx iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a");
        test= new insertionsort(worst);
        test.insertionsort();
        long run3 = System.nanoTime();
        System.out.println((run3-run2)/1000000 +" millisecond time required");
        System.out.println(" INSERTION SORT--!!!! Worst Case is done!!!!");

        myMap avarage = new myMap("eeeee ffffff a hhhhhhhh dddd ccc iiiiiiiii bb xxxxxxxxxx ");
        test = new insertionsort(avarage);
        test.insertionsort();
        
        long run4 = System.nanoTime();
        System.out.println((run4-run3)/1000000 +" millisecond time required");
        System.out.println("INSERTION SORT---------------------Avarage case is don-------------");
    }
    public static void TestSelection(myMap yunus)
    {
        long run1=System.nanoTime();
        selectionsort test = new selectionsort(yunus);
        test.selectionsort();
        long run2= System.nanoTime();
        System.out.println((run2-run1)/1000000 +" millisecond time required");
        System.out.println(" SELECTION SORT--!!!!!!!!!!!!!!!!!!! best case is done!!!!");
        myMap worst = new myMap("xxxxxxxxxx iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a");
        test= new selectionsort(worst);
        test.selectionsort();
        long run3 = System.nanoTime();
        System.out.println((run3-run2)/1000000 +" millisecond time required");
        System.out.println(" SELECTION SORT--!!!! Worst Case is done!!!!");

        myMap avarage = new myMap("eeeee ffffff a hhhhhhhh dddd ccc iiiiiiiii bb xxxxxxxxxx ");
        test = new selectionsort(avarage);
        test.selectionsort();
        
        long run4 = System.nanoTime();
        System.out.println((run4-run3)/1000000 +" millisecond time required");
        System.out.println("SELECTION SORT---------------------Avarage case is don-------------");
    }
    public static void Testquick(myMap yunus)
    {
        long run1=System.nanoTime();
        quicksort test = new quicksort(yunus);
        test.quicksortThem();
        long run2= System.nanoTime();
        System.out.println((run2-run1)/1000000 +" millisecond time required");
        System.out.println(" Quick SORT--!!!!!!!!!!!!!!!!!!! best case is done!!!!");
        myMap worst = new myMap("xxxxxxxxxx iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a");
        test= new quicksort(worst);
        test.quicksortThem();
        long run3 = System.nanoTime();
        System.out.println((run3-run2)/1000000 +" millisecond time required");
        System.out.println(" Quick SORT--!!!! Worst Case is done!!!!");

        myMap avarage = new myMap("eeeee ffffff a hhhhhhhh dddd ccc iiiiiiiii bb xxxxxxxxxx ");
        test = new quicksort(avarage);
        test.quicksortThem();
        
        long run4 = System.nanoTime();
        System.out.println((run4-run3)/1000000 +" millisecond time required");
        System.out.println("Quick SORT---------------------Avarage case is don-------------");
    }
    public static void TestMerge(myMap yunus)
    {
        long run1=System.nanoTime();
        mergeSort test = new mergeSort(yunus);
        test.mergesort();
        long run2= System.nanoTime();
        System.out.println((run2-run1)/1000000 +" millisecond time required");
        System.out.println(" MERGE SORT--!!!!!!!!!!!!!!!!!!! best case is done!!!!");
        myMap worst = new myMap("xxxxxxxxxx iiiiiiiii hhhhhhhh ggggggg ffffff eeeee dddd ccc bb a");
        test= new mergeSort(worst);
        test.mergesort();
        long run3 = System.nanoTime();
        System.out.println((run3-run2)/1000000 +" millisecond time required");
        System.out.println(" MERGE SORT--!!!! Worst Case is done!!!!");

        myMap avarage = new myMap("eeeee ffffff a hhhhhhhh dddd ccc iiiiiiiii bb xxxxxxxxxx ");
        test = new mergeSort(avarage);
        test.mergesort();
        
        long run4 = System.nanoTime();
        System.out.println((run4-run3)/1000000 +" millisecond time required");
        System.out.println("MERGE SORT---------------------Avarage case is don-------------");
    }
}