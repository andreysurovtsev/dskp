package wine;

public class DataClassification extends DataSet {
	private DataSet newData;
	
	public DataClassification(String trainFileName, 
			String newDataFileName) {
		super(trainFileName);
		newData = new DataSet(newDataFileName);		
	}
	
	public DataSet getNewData() {
		return newData;
	}
	
	public int nnClassfication(DataSample datasp) {
		int label = 0;
		
		DataSample[] training = this.getDataSet();
		
		int nn = 0;
		double nnDist = datasp.distance(training[0]);
		
		for (int i = 1; i != training.length; ++i) {
			double dist = datasp.distance(training[i]);
			if (dist < nnDist) {
				nnDist = dist;
				nn = i;
			}
		}
		
		
		
		return training[nn].getLabel();
		
	}
	
}
