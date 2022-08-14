package model;


import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Spliterator;

@Data
public class Root {
    public String label;
    public String slug;
    public String id;
    public String country_code;
    public String country_name;
    public String city_code;
    public String city_name;
    public boolean is_city;
    public String airport;
    public Object ghost_label;


    public List<String> convertToRootList(Root[] roots){
        List<String> rootList = new ArrayList<>();

        for (Root i : roots) {
            String str;
            str = i.city_name + ", " + i.country_name + "\n" + i.airport + "\n" + i.id;
            rootList.add(str);
        }

        return rootList;
    }


}