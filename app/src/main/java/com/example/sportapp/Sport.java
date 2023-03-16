package com.example.sportapp;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

class Sport implements Parcelable {

        //Win: ALT + Insert
        //Mac: Command+ N
        private String sportName;
        private int sportImg;
        private String sportDesc;

        public Sport(String sportName, int sportImg, String sportDesc) {
                this.sportName = sportName;
                this.sportImg = sportImg;
                this.sportDesc = sportDesc;
        }

        protected Sport(Parcel in) {
                sportName = in.readString();
                sportImg = in.readInt();
                sportDesc = in.readString();
        }

        public static final Creator<Sport> CREATOR = new Creator<Sport>() {
                @Override
                public Sport createFromParcel(Parcel in) {
                        return new Sport(in);
                }

                @Override
                public Sport[] newArray(int size) {
                        return new Sport[size];
                }
        };

        public String getSportName() {
                return sportName;
        }
        public int getSportImg() {
                return sportImg;
        }
        public String getSportDesc() {
                return sportDesc;
        }

        @Override
        public int describeContents() {
                return 0;
        }

        @Override
        public void writeToParcel(@NonNull Parcel parcel, int i) {
                parcel.writeString(sportName);
                parcel.writeInt(sportImg);
                parcel.writeString(sportDesc);
        }
}
