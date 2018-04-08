package com.sergiu.newfoodorderclient;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by Sergiu on 4/6/2018.
 */

public class Food  {

        private String name,price,image,desc;
        public Food(){
        }
        public Food(String name,String price,String image,String desc){
            this.name=name;
            this.desc=desc;
            this.price =price;
            this.image=image;
        }
        public String getName(){
            return name;
        }

        public String getPrice(){
            return  price;
        }

        public String getImage(){
            return image;
        }

        public String getDesc(){
            return  desc;
        }

        public void setName(){
            this.name=name;
        }

        public  void setPrice(){
            this.price=price;
        }

    public void setImage(String image) {
        this.image = image;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
