package com.example.presidentlistrecycleview;

import android.app.Application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyApplication extends Application {

    private static List<President> presidentList = new ArrayList<President>();
    public static int nextId = 10;

    public MyApplication() {
        fillPresidentList();
    }

    private void fillPresidentList() {
        President p0 = new President(0, "George Washington", 1788, "https://upload.wikimedia.org/wikipedia/commons/thumb/b/b6/Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg/160px-Gilbert_Stuart_Williamstown_Portrait_of_George_Washington.jpg");
        President p1 = new President( 1, "John Adams", 1796, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/70/John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg/160px-John_Adams%2C_Gilbert_Stuart%2C_c1800_1815.jpg" );
        President p2 = new President(2,"Thomas Jefferson", 1800, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1e/Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg/160px-Thomas_Jefferson_by_Rembrandt_Peale%2C_1800.jpg");
        President p3 = new President(3, "Abraham Lincoln", 1860, "https://upload.wikimedia.org/wikipedia/commons/thumb/a/ab/Abraham_Lincoln_O-77_matte_collodion_print.jpg/160px-Abraham_Lincoln_O-77_matte_collodion_print.jpg");
        President p4 = new President(4, "Ulysses Grant", 1868, "https://upload.wikimedia.org/wikipedia/commons/thumb/7/75/Ulysses_S_Grant_by_Brady_c1870-restored.jpg/160px-Ulysses_S_Grant_by_Brady_c1870-restored.jpg");
        President p5 = new President(5, "Theodore Roosevelt", 1900, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/1c/President_Roosevelt_-_Pach_Bros.jpg/160px-President_Roosevelt_-_Pach_Bros.jpg");
        President p6 = new President(6, "Franklin Roosevelt", 1932,"https://upload.wikimedia.org/wikipedia/commons/thumb/4/42/FDR_1944_Color_Portrait.jpg/160px-FDR_1944_Color_Portrait.jpg");
        President p7 = new President(7, "Harry Truman", 1944, "https://upload.wikimedia.org/wikipedia/commons/thumb/3/39/TRUMAN_58-766-06_CROPPED.jpg/160px-TRUMAN_58-766-06_CROPPED.jpg");
        President p8 = new President(8, "Dwight Eisenhower", 1952, "https://upload.wikimedia.org/wikipedia/commons/thumb/6/63/Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg/160px-Dwight_D._Eisenhower%2C_official_photo_portrait%2C_May_29%2C_1959.jpg");
        President p9 = new President(9, "Ronald Regan", 1980, "https://upload.wikimedia.org/wikipedia/commons/thumb/1/16/Official_Portrait_of_President_Reagan_1981.jpg/165px-Official_Portrait_of_President_Reagan_1981.jpg");
        presidentList.addAll(Arrays.asList(new President[] {p0, p1 ,p2, p3, p4 , p5 , p6, p7, p8, p9}));
    }

    public static List<President> getPresidentList() {
        return presidentList;
    }

    public static void setPresidentList(List<President> presidentList) {
        MyApplication.presidentList = presidentList;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        MyApplication.nextId = nextId;
    }

}
