package edu.touro.ds.model;

import java.util.Arrays;
import java.util.List;

/**
 * Utility class to manage aspects of LanderStudent objects
 */
public class LanderStudentUtils {

    private LanderStudentUtils() {
    }


    /**
     * Generate demonstration/test data
     *
     * @return List of Students
     */
    static public List<LanderStudent> generateDemoStudents() {

        /* worst case  */
        return Arrays.asList(
                new LanderStudent("Sill", "Daniel", true, 2002),
                new LanderStudent("Greenspan", "Steve", true, 2000),
                new LanderStudent("Kennedy", "Tom", true, 1999),
                new LanderStudent("Artzt", "Russell", true, 1955)
        );
        /****/

        /* medium case
        return Arrays.asList(

                new LanderStudent("Greenspan", "Steve", true, 2000),
                new LanderStudent("Artzt", "Russell", true, 1955),
                new LanderStudent("Kennedy", "Tom", true, 1999),
                new LanderStudent("Sill", "Daniel", true, 2002)

        );
        /****/


        /* best case
        return Arrays.asList(
                new LanderStudent("Sill", "Daniel", true, 2002),
                new LanderStudent("Greenspan", "Steve", true, 2000),
                new LanderStudent("Kennedy", "Tom", true, 1999),
                new LanderStudent("Artzt", "Russell", true, 1955)
        );
        /*****/

    }


    /**
     * Demo bubblesort
     * <a href="https://stackoverflow.com/questions/5370829/bubblesort-over-other-sorting-algorithms">...</a>
     * @param persons a collection to be sorted using naural order of its objects
     */
    public static void bubbleSort(List<LanderStudent> persons) {
int  _ncompare=0, _nswap =0;
dbugprint("\nbefore bubblesort: ncomp:_nswap  " + _ncompare +":" + _nswap, persons);

        for (int i = 0; i < persons.size() - 1; i++) {
            boolean allSorted = true;
            for (int j = 0; j < (persons.size() - 1) - i; j++ ){
_ncompare++;
dbugprint("   i/j ncomp:_nswap " + i + "/" + j + " " + _ncompare +":" + _nswap, persons);

                if (persons.get(j).compareTo(persons.get(j+1)) > 0)  {
_nswap++;
System.out.println("      SWAP: move right>>> " + persons.get(j).getYearOfBirth());
                    LanderStudent temp = persons.get(j);
                    persons.set(j, persons.get(j+1));
                    persons.set(j+1, temp);
                    allSorted = false;
                }

            }
            if (allSorted)
                break;
        }

dbugprint("after bubble" +
        "sort: ncomp:_nswap " + _ncompare +":" + _nswap, persons);
    }

    private static void dbugprint(String msg, List<LanderStudent> persons) {
        System.out.print(msg + " -> ");
        for (LanderStudent ls : persons) {
            System.out.print(ls.getYearOfBirth() + ":" + ls.getLastName() + ", ");
        }
        System.out.println();
    }
}
