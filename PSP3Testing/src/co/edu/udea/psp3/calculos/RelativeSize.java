package co.edu.udea.psp3.calculos;

import java.util.LinkedList;
import java.util.List;

import co.edu.udea.testing.psp3.exceptions.CalculoException;

public class RelativeSize {
	
	public final short VERY_SMALL = -2;
	public final short SMALL = -1;
	public final short MEDIUM = 0;
	public final short LARGE = 1;
	public final short VERY_LARGE = 2;
	
	List<Double> partSizeList;
	List<Double> numberItemsList;
	
	private Double verySmall = 0.0;
	private Double small = 0.0;
	private Double medium = 0.0;
	private Double large = 0.0;
	private Double veryLarge = 0.0;
	
	public RelativeSize() {
		partSizeList = new LinkedList<>();
		numberItemsList = new LinkedList<>();
	}

	public RelativeSize(List<Double> partSizeList, List<Double> numberItemsList) throws CalculoException {
		super();
		this.partSizeList = partSizeList;
		this.numberItemsList = numberItemsList;
		estimateRelativeSizes();
	}

	
	public Double getVerySmall() {
		return verySmall;
	}

	public Double getSmall() {
		return small;
	}

	public Double getMedium() {
		return medium;
	}

	public Double getLarge() {
		return large;
	}

	public Double getVeryLarge() {
		return veryLarge;
	}
	
	/**
	 * Add a part size with the respective number of items and recalculate the Relative sizes.	
	 * @param partSize Part size to be added
	 * @param numberItems Number of Items which the part is divided.
	 * @throws CalculoException
	 */
	public void addPartSizeWithNumberItems(Double partSize, Double numberItems) throws CalculoException{
		partSizeList.add(partSize);
		numberItemsList.add(numberItems);
		estimateRelativeSizes();
	}
	
	/**
	 * Estimate a list of size per item based in a list of
	 * part size and a list of number of items in each part.
	 * @param partSizeList List with the list of sizes of each part.
	 * @param numberItemsList List with the number of items in each part.
	 * @return List with the sizes per Item.
	 * @throws CalculoException 
	 */
	private List<Double> calculateSizesPerItem() throws CalculoException{
		
		List<Double> sizesPerItemList = new LinkedList<>();
		
		int sizePartList = partSizeList.size();
		int sizeitemsList = numberItemsList.size();
		
		if(sizePartList != sizeitemsList){
			throw new CalculoException("The lists of number Items and parts size are not the same.");
		}
		
		
		for (int i = 0; i < sizeitemsList; i++) {
			
			Double sizePerItem = partSizeList.get(i)/numberItemsList.get(i);			
			sizesPerItemList.add(sizePerItem);
		}
		
		return sizesPerItemList;
		
	}
	
	/**
	 *  Transform the data to Log-Normally.
	 * @param sizesPerItemList
	 * @return
	 * @throws CalculoException
	 */
	private List<Double> estimateLogNormally(List<Double> sizesPerItemList) throws CalculoException{
		
		List<Double> logNormallyOfSizesList = new LinkedList<>();
		
		for (Double sizePerItem : sizesPerItemList) {
			logNormallyOfSizesList.add(Math.log(sizePerItem));
		}
		
		return logNormallyOfSizesList;
	}
	
	/**
	 * Make the estimation of Relative sizes with the parts
	 *  sizes and number of items for each part specified.
	 * @throws CalculoException
	 */
	private void estimateRelativeSizes() throws CalculoException{
		
		List<Double> logNormallyList = estimateLogNormally(calculateSizesPerItem());
		
		Double mean = Calculos.calcularMedia(logNormallyList);
		Double devEst = Calculos.calcularDesviacion(logNormallyList);
		
		Double vsLogarithmicRange = mean + VERY_SMALL * devEst;
		Double sLogarithmicRange = mean + SMALL * devEst;
		Double mLogarithmicRange = mean + MEDIUM * devEst;
		Double lLogarithmicRange = mean + LARGE * devEst;
		Double vlLogarithmicRange = mean + VERY_LARGE * devEst;
		
		verySmall = Math.exp(vsLogarithmicRange);
		small = Math.exp(sLogarithmicRange);
		medium = Math.exp(mLogarithmicRange);
		large = Math.exp(lLogarithmicRange);
		veryLarge = Math.exp(vlLogarithmicRange);
		
	}
	
}
