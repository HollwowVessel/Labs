public class AnyUser extends User{
    @Override
    public void printGroups() {
        for(Group group : this.groups){
            System.out.println(group);
        }
    }

    @Override
    public void printGroupMembers(String name) {
        for(Group group : this.groups){
            if(group.getName().equals(name)){
                for(Member member : group.getMembers()){
                    System.out.println(member);
                }
            }
        }
    }
}
