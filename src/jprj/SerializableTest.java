package jprj;


	//Serializableは日本語で「直列化」といいます。
	//オブジェクトを出力ストリームに書き出すことをシリアライズまたは直列化と呼びます。
	//また、シリアライズされたオブジェクトを読み込んで、メモリ上に復元することをデシリアライズまたは直列化復元と呼びます。
	//通常、オブジェクトはそのままストリームに書き出して読み込むことが出来ないので、
	//読み書きできる形にデータを整形する事をシリアライズ（直列化）と呼んでいるようです。
	
	
import java.io.*;


public class SerializableTest {

    public static void main(String args[]) {
        // シリアライズ
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("person.txt"))) {
            Person person = new Person("John", "Williams", 55);
            oos.writeObject(person);
        } catch (IOException e) {
        }

        // デシリアライズ
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("person.txt"))) {
            Person dePerson = (Person) ois.readObject();

           System.out.println(dePerson.getFirstName());
           System.out.println(dePerson.getLastName());
           System.out.println(dePerson.getAge());
        } catch (IOException | ClassNotFoundException e) {
        }

    }
}
