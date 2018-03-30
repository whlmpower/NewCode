//import sort_application.NumberOfInverseParis;
//import temp.Power2N;
//
//
///**
// * Created by Administrator on 2018/03/04 0004.
// */
//public class Main {
//    public static void main(String[] args) {
////        Roate_KPM roate_kpm = new Roate_KPM();
////        System.out.println(roate_kpm.chkRotation("12345", 5, "45123", 5));
////        MoveIndexSplitStr moveIndexSplitStr = new MoveIndexSplitStr();
////        System.out.println(moveIndexSplitStr.stringTranslation("RJXJYA", 6, 1));
////
//////        System.out.println(moveIndexSplitStr.moveIndex(2, "ABCDE"));
////        int[]  a = new int[]{54,35,48,36,27,12,44,44,8,14,26,17,28};
////        BubbleSort bubbleSort = new BubbleSort();
////        int[] b = bubbleSort.bubbleSort(a, 6);
////        SelectionSort selectionSort = new SelectionSort();
////        System.out.println(selectionSort.selectMax(a, 0, 5));
////        int[] b = selectionSort.selectionSort(a, 6);
////        InsertionSort insertionSort = new InsertionSort();
////        System.out.println(insertionSort.search(a, 0,3, 4));
////        int[] b = insertionSort.insertSort(a, 6);
//
////        MergeSort mergeSort = new MergeSort();
////        int[] b =mergeSort.mergeSort(a, 6);
//
////        QucikSort qucikSort = new QucikSort();
////        int[] b = qucikSort.quickSort(a, 10);
//
////        int[] b = new int[]{2,1,4,3,6,5,8,7,10,10};
////        HeapSort heapSort = new HeapSort();
////        int[] c = heapSort.heapSort(b, 10);
////        for (int i = 0; i < c.length; i++) {
////            System.out.println(c[i]);
////        }
//
////        int[] b = heapSort.heapSort(a, 6);
////        CountSort countSort = new CountSort();
////        int[] b = countSort.countSort(a, 10);
//
////        RadixSort radixSort = new RadixSort();
////        int[] b = radixSort.radixSort(a, 13);
//
//
////        ScaleSort scaleSort = new ScaleSort();
////        int[] c = scaleSort.sortElement(b, 10, 2);
////
////        CheckDuplicate checkDuplicate = new CheckDuplicate();
////        int[] c = checkDuplicate.sort(b, 10);
////        for (int i = 0; i < c.length; i++) {
////            System.out.println(c[i]);
////        }
////        System.out.println(checkDuplicate.checkDuplicate(b, 10));
////        System.out.println(checkDuplicate.checkDuplicate(a, 13));
//
////        int[] A = new int[]{1,2,0,2};
////        ThreeColor threeColor = new ThreeColor();
////        A= threeColor.sortThreeColor(A, 4);
////        for (int i = 0; i < A.length; i++) {
////            System.out.println(A[i]);
////        }
//
////        TreeNode node1 = new TreeNode(1);
////        TreeNode node2 = new TreeNode(2);
////        TreeNode node3 = new TreeNode(3);
////        TreeNode node4 = new TreeNode(1);
////
////        node1.left = node2;
////        node1.right = node3;
////
////        IdenticalTree identicalTree = new IdenticalTree();
////        System.out.println(identicalTree.chkIdentical(node1, node4));
//
////        String s = "123";
////        char[] chars = s.toCharArray();
////        Arrays.sort(chars);
////        for (char i: chars
////             ) {
////            System.out.println(i);
////        }
////        StringPermutation stringPermutation = new StringPermutation();
////        ArrayList<String> list = stringPermutation.Permutation2(s);
////        list.forEach(System.out::println);
////        Iterator it = list.iterator();
////        it.forEachRemaining(o -> System.out.println("迭代集合元素：" + o));
////        int[] poe = new int[]{2, 3, 4, 5, 1};
////        TwoStackLikeQueue twoStackLikeQueue = new TwoStackLikeQueue();
////        int[] num = twoStackLikeQueue.twoStack(poe, 6);
////        for (int i = 0; i < num.length; i++) {
////            System.out.println(num[i]);
////        }
////        TwoStackSort twoStackSort = new TwoStackSort();
////        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2.compareTo(o1));
////        FindKthNumInArray findKthNumInArray = new FindKthNumInArray();
////        System.out.println(findKthNumInArray.KthofArray(poe, 5, 0, 4));
////        int[] b = findKthNumInArray.kthArray(poe, 2);
////        FindKthNumInArray2 findKthNumInArray2 = new FindKthNumInArray2();
////        int[] b = findKthNumInArray2.kthNumArray(poe, 2);
////        int[] a = new int[]{308,427,36,77,147,144,273};
////        SlideWindow slideWindow = new SlideWindow();
////        int[] b = slideWindow.slide(a, 7, 6);
////        for (int i = 0; i < b.length; i++) {
////            System.out.println(b[i]);
////        }
//
////        String result = Power2N.expString(2, 7);
////        System.out.println(result);
//
//        int[] a = new int[]{7, 5, 4, 6};
//        NumberOfInverseParis numberOfInverseParis = new NumberOfInverseParis();
//        System.out.println(numberOfInverseParis.inversePairs(a));
//
//    }
//
//}

import temp.PkIsContinuous;

public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {//注意while处理多个case
//            int a = in.nextInt();
//            int b = in.nextInt();
//            System.out.println(a + b);
//        }

//        TreeNode root = new TreeNode(10);
//        TreeNode node1 = new TreeNode(5);
//        TreeNode node2 = new TreeNode(4);
//        TreeNode node3 = new TreeNode(7);
//        root.left = node1;
//        node1.left = node2;
//        node1.right = node3;
//        SumCertainPath2 sumCertainPath2 = new SumCertainPath2();
//        sumCertainPath2.FindPath(root, 22);
        int[] numbers = new int[]{1, 3, 5, 2, 0};
        PkIsContinuous pkIsContinuous = new PkIsContinuous();
        System.out.println(pkIsContinuous.isContinuous(numbers));
    }
}
