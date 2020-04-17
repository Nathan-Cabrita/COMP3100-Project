package Config;

public class Job{

    public String submitTime, id, estRunTime, cores, memory, disk;

    public Job(String submitTime, String id, String estRunTime, String cores, String memory, String disk){
        this.submitTime = submitTime;
        this.id = id;
        this.estRunTime = estRunTime;
        this.cores = cores;
        this.memory = memory;
        this.disk = disk;
    }

    public String toString(){
        return("Job Details and Requirements - Submit Time: " + this.submitTime + " ID: " + this.id + " Estimated Run Time: " + this.estRunTime + " Cores: " + this.cores + " Memory: " + this.memory + " Disk: " + this.disk);
    }
}