package test.fcm.practice04;

import android.os.Parcel;
import android.os.Parcelable;

public class SimpleData implements Parcelable {
    int number;
    String message;

    public SimpleData(int num,String msg){
        number = num;
        message = msg;
    }
    protected SimpleData(Parcel src) {
        number = src.readInt();
        message = src.readString();
    }

    public static final Creator<SimpleData> CREATOR = new Creator<SimpleData>() {

        public SimpleData createFromParcel(Parcel in) {
            return new SimpleData(in);
        }

        public SimpleData[] newArray(int size) {
            return new SimpleData[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(number);
        dest.writeString(message);
    }
}
