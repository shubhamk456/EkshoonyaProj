package com.example.ekshoonaya;



public class Item {

    int imageId;
    String desc;
    String inst_name;
    String ins_desc;
    int ins_image;

    public String getInst_name() {
        return inst_name;
    }

    public void setInst_name(String inst_name) {
        this.inst_name = inst_name;
    }

    public String getIns_desc() {
        return ins_desc;
    }

    public void setIns_desc(String ins_desc) {
        this.ins_desc = ins_desc;
    }

    public int getIns_image() {
        return ins_image;
    }

    public void setIns_image(int ins_image) {
        this.ins_image = ins_image;
    }

    public Item(int imageId, String desc, String inst_name, String ins_desc, int ins_image) {

        this.imageId = imageId;
        this.desc = desc;
        this.inst_name=inst_name;
        this.ins_desc=ins_desc;
        this.ins_image=ins_image;

    }

    public int getImageId()
    {
        return imageId;
    }

    public void setImageId(int imageId) {

        this.imageId = imageId;
    }

    public String getDesc()
    {
        return desc;
    }

    public void setDesc(String desc)
    {
        this.desc = desc;
    }


}
