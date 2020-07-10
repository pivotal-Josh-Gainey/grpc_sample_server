
import io.grpc.stub.StreamObserver;
import personpackage.PersonOuterClass;
import personpackage.personServiceGrpc;

public class PersonService extends personServiceGrpc.personServiceImplBase {
    @Override
    public void addPerson(PersonOuterClass.Person request, StreamObserver<PersonOuterClass.Person> responseObserver) {
        String name = request.getName();
        int age = request.getAge();

        PersonOuterClass.Person.Builder response = PersonOuterClass.Person.newBuilder();
        if(age>30){
            System.out.println(name+" is over 30");
        }else{
            System.out.println(name+" is under 30");
        }

        responseObserver.onNext(response.build());
        responseObserver.onCompleted();
    }
}
