package sortVisualiser;

public class SortThread implements Runnable{

    private VisualiserDriver.SortType currentSort;
    private SVPanel svPanel;

    public SortThread(VisualiserDriver.SortType currentSort, SVPanel svPanel) {
        this.currentSort = currentSort;
        this.svPanel = svPanel;
    }


    public void run(){
        svPanel.arrayRandom();
        switch (currentSort){
            case QS:
                QuickSort qSort = new QuickSort();
                qSort.sort(svPanel);
                break;
            case MS:
                MergeSort mSort = new MergeSort();
                mSort.sort(svPanel);
                break;
            case IS:
                InsertionSort iSort = new InsertionSort();
                iSort.sort(svPanel);
                break;
        }
    }
}
