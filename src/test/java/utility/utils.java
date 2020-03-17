package utility;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class utils {

    public static List<String> getAddress(String test_addressLine){

        List<String> houseNumList = new ArrayList<String>();
        List<String> streetList = new ArrayList<String>();

        String[] addressData = test_addressLine.split(" ");
        System.out.println("output string: " + Arrays.toString(addressData));

        for(int i=0 ; i<= addressData.length ; i++){

            String tempData = addressData[i].replaceAll("[,]", "");


        }
        List<String> addressDataList = new ArrayList<String>();
        return addressDataList;
    }

    public static List<String> getTestData (String fileName){
        List<String> testAddressDataList = new ArrayList<String>();
        String rootPath = Paths.get("").toAbsolutePath().toString() +"\\resource\\"+ fileName;
        try (FileReader reader = new FileReader(rootPath);
             BufferedReader br = new BufferedReader(reader)) {
            // read line by line
            String line;
            while ((line = br.readLine()) != null) {
                testAddressDataList.add(line);
            }
        } catch (IOException e) {
            //e
        }
        return testAddressDataList;
    }

    public static  List<String> getAddressDetails(String[] address){
        List<String> addressList = new ArrayList<String>();
        String outputStreetList = "";
        String outputHouseList =  "";
        List<String> houseNumList = new ArrayList<String>();
        List<String> streetList = new ArrayList<String>();
        int index = 0;
        int totalLengh = address.length;
        int counter = 0;
        boolean removePlusIndex = false;
        boolean removeMinusIndex = false;
        String value_One_minus_index ="";
        String value_One_plus_index ="";
        boolean checkMethod = false;
        List<String> dummyList = checkNoStringinAddress(address);
        if (dummyList.size() != 0 ){
            String[] address_data = checkNoStringinAddress(address).toArray(new String[0]);
            outputStreetList = address_data[0].replaceAll("[,\\[]", "");
            outputHouseList = address_data[1].replaceAll("[,\\]]", "");
            addressList.add(outputStreetList);
            addressList.add("No "+outputHouseList);
        }else{
            for ( String data : address){
                counter++;
                boolean isContainsDigit = utils.containsDigit(data);
                if(isContainsDigit){
                    index = Arrays.asList(address).indexOf(data);
                    if(totalLengh > counter){
                        value_One_minus_index = address[index+1];
                        if(checkLength(value_One_minus_index)){
                            removeMinusIndex = true;
                        }
                    }else if(totalLengh == counter){
                        value_One_plus_index =  address[index-1];
                        if(checkLength(value_One_plus_index)){
                            removePlusIndex = true;
                        }
                    }
                    houseNumList.add(data);
                }else{
                    streetList.add(data);
                }
            }
            if(removePlusIndex){
                houseNumList.add(0, value_One_plus_index);
                streetList.remove(value_One_plus_index);
            }
            if(removeMinusIndex){
                houseNumList.add( value_One_minus_index);
                streetList.remove(value_One_minus_index);
            }
             outputStreetList = listAsString(streetList);
             outputHouseList =  listAsString(houseNumList);
            addressList.add(outputStreetList);
            addressList.add(outputHouseList);
        }
        return addressList;
    }

    public static List<String> checkNoStringinAddress (String[] myList){
        boolean checkMethod = false;
        boolean splitString = false;
        String[] addressArray = null;
        String addressData = Arrays.toString(myList);
        for(String str: myList) {
            if(str.trim().equalsIgnoreCase("No") ){
                addressArray = addressData.split("No");
                splitString = true;
                break;
            }else if (str.trim().equalsIgnoreCase("No.")){
                addressArray = addressData.split("No.");
                splitString = true;
                break;
            }else{
                splitString = false;
            }
        }
        List<String> details = new ArrayList<String>();
        if(splitString){
            details = Arrays.asList(addressArray);
        }
        return details;
    }
    public static boolean checkLength (String str){
        boolean flag = false;
        if(str.length() == 1){
            flag = true;
        }else{
            flag = false;
        }
        return flag;
    }

    public static String listAsString (List<String> List_value){
        String outputString = "";

        for (String s : List_value)
        {
            outputString += s + " ";
        }
        return outputString.trim();
    }

    public static final boolean containsDigit(String s) {
        boolean containsDigit = true;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }
}
