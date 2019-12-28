package project.rexkyoo.Economy;

public class TypePercentagesModel
{
    private double cleaningPercentage;
    private double babysittingPercentage;
    private double homeworkPercentage;
    private double miscellaneousPercentage;

    public TypePercentagesModel(double cleaningPercentage, double babysittingPercentage, double homeworkPercentage, double miscellaneousPercentage)
    {
        this.cleaningPercentage = cleaningPercentage;
        this.babysittingPercentage = babysittingPercentage;
        this.homeworkPercentage = homeworkPercentage;
        this.miscellaneousPercentage = miscellaneousPercentage;
    }

    public double getCleaningPercentage()
    {
        return cleaningPercentage;
    }

    public void setCleaningPercentage(double cleaningPercentage)
    {
        this.cleaningPercentage = cleaningPercentage;
    }

    public double getBabysittingPercentage()
    {
        return babysittingPercentage;
    }

    public void setBabysittingPercentage(double babysittingPercentage)
    {
        this.babysittingPercentage = babysittingPercentage;
    }

    public double getHomeworkPercentage()
    {
        return homeworkPercentage;
    }

    public void setHomeworkPercentage(double homeworkPercentage)
    {
        this.homeworkPercentage = homeworkPercentage;
    }

    public double getMiscellaneousPercentage()
    {
        return miscellaneousPercentage;
    }

    public void setMiscellaneousPercentage(double miscellaneousPercentage)
    {
        this.miscellaneousPercentage = miscellaneousPercentage;
    }
}
