package newjavaprograms.cleancodefunction;

public class ArgumentObject {


    public void person(){
        Person person = new Person();
        int id = person.id;
//        String name = person.name;
        String newName = "Hello";
        updateName(id, newName);
        person.setName(newName);//use object to pass multiple arguments.
    }

    public void updateName(int id, String name){
//        getStudentById
//        updateName
    }


    public class Person{
        int id;
        String name;
        String addres;
        String email;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAddres() {
            return addres;
        }

        public void setAddres(String addres) {
            this.addres = addres;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }
    }
}
