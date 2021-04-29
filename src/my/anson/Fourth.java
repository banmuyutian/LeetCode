package my.anson;

import java.util.Objects;

public class Fourth {

	public static void main(String[] args) {
		Fourth fourth = new Fourth();
		int[] nums1 = new int[]{2, 2, 2, 2};
		int[] nums2 = new int[]{2, 2, 2};
		double result = fourth.findMedianSortedArrays(nums1, nums2);
		System.out.println(result);
	}

	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int maxL = nums1.length + nums2.length;
		int flag1 = 0, flag2 = 0;
		int midNumSum = 0;
		int logicIndex = 0;
		if (maxL % 2 == 0) {
			int tFlag1 = (maxL / 2) - 1;
			int tFlag2 = maxL / 2;
			while (logicIndex < maxL && logicIndex <= tFlag2) {
				if (flag1 >= nums1.length && flag2 >= nums2.length) {
					break;
				}
				Integer i1 = null;
				if (flag1 < nums1.length) {
					i1 = nums1[flag1];
				}
				Integer i2 = null;
				if (flag2 < nums2.length) {
					i2 = nums2[flag2];
				}
				if (compare(i1, i2) == -1) {
					if (Objects.nonNull(i1)) {
						if (logicIndex == tFlag1 || logicIndex == tFlag2) {
							midNumSum += i1;
						}
						flag1++;
					} else {
						if (logicIndex == tFlag1 || logicIndex == tFlag2) {
							midNumSum += i2;
						}
						flag2++;
					}
				} else if (compare(i1, i2) == 1) {
					if (Objects.nonNull(i2)) {
						if (logicIndex == tFlag1 || logicIndex == tFlag2) {
							midNumSum += i2;
						}
						flag2++;
					} else {
						if (logicIndex == tFlag1 || logicIndex == tFlag2) {
							midNumSum += i1;
						}
						flag1++;
					}
				} else {
					if (logicIndex == tFlag1 || logicIndex == tFlag2) {
						midNumSum += i1;
					}
					logicIndex++;
					if (logicIndex == tFlag1 || logicIndex == tFlag2) {
						midNumSum += i2;
					}
					flag1++;
					flag2++;
					logicIndex++;
					continue;
				}
				logicIndex++;

			}
			return midNumSum / 2.00000;
		} else {
			int tFlag = (maxL / 2);
			while (logicIndex < maxL && logicIndex <= tFlag) {
				Integer i1 = null;
				if (flag1 < nums1.length) {
					i1 = nums1[flag1];
				}
				Integer i2 = null;
				if (flag2 < nums2.length) {
					i2 = nums2[flag2];
				}
				if (compare(i1, i2) == -1) {
					if (Objects.nonNull(i1)) {
						if (logicIndex == tFlag) {
							midNumSum += i1;
						}
						flag1++;
					} else {
						if (logicIndex == tFlag) {
							midNumSum += i2;
						}
						flag2++;
					}
				} else if (compare(i1, i2) == 1) {
					if (Objects.nonNull(i2)) {
						if (logicIndex == tFlag) {
							midNumSum += i2;
						}
						flag2++;
					} else {
						if (logicIndex == tFlag) {
							midNumSum += i1;
						}
						flag1++;
					}
				} else {
					if (logicIndex == tFlag) {
						midNumSum += i1;
					}
					logicIndex++;
					if (logicIndex == tFlag) {
						midNumSum += i1;
					}
					flag1++;
					flag2++;
					logicIndex++;
					continue;
				}
				logicIndex++;
			}
			return midNumSum / 1.00000;
		}
	}

	/**
	 * <,=,>    -1,0,1
	 *
	 * @param i1
	 * @param i2
	 * @return
	 */
	public int compare(Integer i1, Integer i2) {
		if (Objects.isNull(i1) && Objects.nonNull(i2)) {
			return -1;
		} else if (Objects.nonNull(i1) && Objects.isNull(i2)) {
			return 1;
		} else {
			return i1.compareTo(i2);
		}
	}
}
