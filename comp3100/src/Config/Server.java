package Config;

public class Server{

    public String type, limit, bootupTime, coreCount, memory, disk, hourlyRate;

    public Server(String type, String limit, String bootupTime, String hourlyRate, String coreCount, String memory, String disk){
        this.type = type;
        this.limit = limit;
        this.bootupTime = bootupTime;
        this.hourlyRate = hourlyRate;
        this.coreCount = coreCount;
        this.memory = memory;
        this.disk = disk;
    }

    public String toString(){
        return("Server - Type: " + this.type + " Limit: " + this.limit + " Bootup Time: " + this.bootupTime + " Hourly Rate: " + this.hourlyRate + " Core Count: " + this.coreCount + " Memory: " + this.memory + " Disk: " + this.disk);
    }
}