

package com.bhq.bean;

import android.os.Parcel;
import android.os.Parcelable;

import com.lidroid.xutils.db.annotation.NoAutoIncrement;
import com.lidroid.xutils.db.annotation.Table;

/**
 *
 * Description: AppAnnouncement 实体类
 *
 * Copyright: Copyright (c) 2015
 *
 * Company: 广州海川信息科技有限公司
 * @version 1.0 时间 2015-3-3
 */
@Table(name="AppAnnouncement")
public class AppAnnouncement implements Parcelable 
{
  public static final Parcelable.Creator<AppAnnouncement> CREATOR = new Creator()
  {  
      @Override  
      public AppAnnouncement createFromParcel(Parcel source)
      {  
         // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错  
    	 AppAnnouncement p = new AppAnnouncement();
         p.setId(source.readInt());
         p.setTitle(source.readString());
         p.setImgPath(source.readString());
         p.setBDLJ(source.readString());
         p.setContent(source.readString());
         p.setPubDate(source.readString());
         p.setUserId(source.readString());
         p.setIsPublish(source.readInt()==0);
         return p;  
      }  

      @Override  
      public AppAnnouncement[] newArray(int size) 
      {  
          return new AppAnnouncement[size];  
      }  
  }; 

    String BDLJ;
    public void setBDLJ(String bDLJ) {
		BDLJ = bDLJ;
	}
    public String getBDLJ() {
		return BDLJ;
	}
    Boolean Change;
    public void setChange(Boolean change) {
		Change = change;
	}
    public Boolean getChange() {
		return Change;
	}
	/** identifier field */
   @NoAutoIncrement
	private int id;
    
	/** identifier field */

	private String Title;
    
	/** identifier field */

	private String ImgPath;
    
	/** identifier field */

	private String Content;
    
	/** identifier field */

	private String PubDate;
    
	/** identifier field */

	private String UserId;
    
	/** identifier field */

	private Boolean IsPublish;

    public void setId(int id) {
		this.id = id;
	}
    public int getId() {
		return id;
	}
	/**
	 * @return 返回 公告标题
	 */
	public String getTitle() {
		return Title;
	}

	/**
	 * @param Title 要设置的  公告标题
	 */
	public void setTitle(String Title) {
		this.Title = Title;
	}
	/**
	 * @return 返回 图片路径
	 */
	public String getImgPath() {
		return ImgPath;
	}

	/**
	 * @param ImgPath 要设置的  图片路径
	 */
	public void setImgPath(String ImgPath) {
		this.ImgPath = ImgPath;
	}
	/**
	 * @return 返回 公告内容
	 */
	public String getContent() {
		return Content;
	}

	/**
	 * @param Content 要设置的  公告内容
	 */
	public void setContent(String Content) {
		this.Content = Content;
	}
	/**
	 * @return 返回 发布时间
	 */
	public String getPubDate() {
		return PubDate;
	}

	/**
	 * @param PubDate 要设置的  发布时间
	 */
	public void setPubDate(String PubDate) {
		this.PubDate = PubDate;
	}
	/**
	 * @return 返回 发布人
	 */
	public String getUserId() {
		return UserId;
	}

	/**
	 * @param UserId 要设置的  发布人
	 */
	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

   public void setIsPublish(Boolean isPublish) {
	IsPublish = isPublish;
}
   public Boolean getIsPublish() {
	return IsPublish;
}
	
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean equals(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	public int hashCode() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
public int describeContents()
{
	return 0;
}
@Override
public void writeToParcel(Parcel p, int arg1) 
{
  p.writeInt(id);  
  p.writeString(Title);  
  p.writeString(ImgPath);  
  p.writeString(BDLJ);  
  p.writeString(Content);  
  p.writeString(PubDate);  
  p.writeString(UserId);  
  p.writeInt(IsPublish?0:1);
}
}
