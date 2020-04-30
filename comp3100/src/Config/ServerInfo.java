package Config;

public class ServerInfo{

    public String type, id, state, availableTime, coreCount, memory, disk;

    public ServerInfo(String type, String id, String state, String availableTime, String coreCount, String memory, String disk){
        this.type = type;
        this.id = id;
        this.state = state;
        this.availableTime = availableTime;
        this.coreCount = coreCount;
        this.memory = memory;
        this.disk = disk;
    }

    public String toString(){
        return("Server - Type: " + this.type + " ID: " + this.id + " State: " + this.state + " Available Time: " + this.availableTime + " Core Count: " + this.coreCount + " Memory: " + this.memory + " Disk: " + this.disk);
    }
}