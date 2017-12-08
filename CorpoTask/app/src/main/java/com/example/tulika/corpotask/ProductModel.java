package com.example.tulika.corpotask;



public class ProductModel {


    int rank;

    String country;
    ProductModel(int rank, String country, String flag, String population)
    {
        this.rank=rank;
        this.country=country;
        this.flag=flag;
        this.population=population;
    }

    public String getRank() {
        return String.valueOf(rank);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }


    String population;

    String flag;




}