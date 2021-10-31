//package com.example.SuccessCadets.model;
//
////import com.example.SuccessCadets.controls.MainControls;
//
//import javax.persistence.Column;
//import javax.persistence.Id;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.stream.Collectors;
//
//
//public class Group {
//    @Id
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    int number;
//    List<Cadet> cadets= new ArrayList<Cadet>(){};
//    double middle_grade_of_group;
//    double progress_group;
//
//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }
//
//    public Group(){}
//
//    public Group(int number, List<Cadet> cadets) {
//        this.number = number;
//        this.cadets = cadets;
//        this.middle_grade_of_group = middle_gr_group();
//    }
//
//
//    public List<Cadet> getCadets() {
//        return this.cadets;
//    }
//
//    public void setCadets(List<Cadet> cadets) {
//        this.cadets = cadets;
//    }
//
//    public int getNumber() {
//        return number;
//    }
//
//    public void setNumber(int number) {
//        this.number = number;
//    }
//
//    public double getMiddle_grade() {
//        return middle_grade_of_group;
//    }
//
//    public void setMiddle_grade(double middle_grade) {
//        this.middle_grade_of_group = middle_grade_of_group;
//    }
//
//    public double getProgress() {
//        return progress_group;
//    }
//
//    public void setProgress(double progress) {
//        this.progress_group = progress_group;
//    }
//    public double
//    middle_gr_group(){
//        double notes =0;
//        for(int i=0; i<cadets.size(); i++){
//            notes+=cadets.get(i).getGrade();
//        }
//         double middle = notes/cadets.size();
//        middle =Double.parseDouble(String.format("%.2f",middle).substring(0,2)+"."+String.format("%.2f",middle).substring(3)) ;
//
//        return middle;
//    }
//
//
//    public List<Cadet> top_cadets(){
//
//        List<Cadet> groups1 =  (List<Cadet>)cadets.stream().sorted((o1, o2) -> (int) (o2.getGrade()-o1.getGrade())).limit(5).collect(Collectors.toList());
//        return groups1;
//    }
//
//}
//
