package utils;

import  java.io.*;

public class FileManager {
    public  boolean isFileExists(){
        File file = new File("C:\\Users\\DINH HUY KHANH\\Desktop\\Test.txt");
        if(file.exists()) return true;
        return false;
    }
    public void checkfile(){
        System.out.println(isFileExists()==true ?"File tồn tại":"File chưa tồn tại");
    }

    public void createNewFile(String file){
        File file1 = new File(file);
        try{
            checkfile(file1);
        }catch (ExceptionFile e)
        {
            System.out.println(e.getMessage());
        }

    }

    public void createNewFile(String path,String file)
    {
        File file1 = new File(path+"\\"+file);
        try
        {
            checkfile(file1);
        }catch (ExceptionFile e)
        {
            System.out.println(e.getMessage());
        }
    }

    static void checkfile(File file) throws ExceptionFile{
        if(file.exists()){
            throw  new ExceptionFile("Error! File Exist.");
        }
        else{
            throw new ExceptionFile("Error! File Not Exist.");

        }
    }

    public void deleteFile(String pathFile){
        File file = new File(pathFile);
        try
        {
            checkfile(file);
        }catch (ExceptionFile e)
        {
            System.out.println(e.getMessage());
        }
        file.delete();
    }

    public boolean isFolder(String file){
        File file1 = new File(file);
        if(file1.isDirectory()) return  true;
        return false;
    }

}
