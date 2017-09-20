package com.os;

import java.util.Scanner;

public class Banker {
	static int available[] = new int[3]; // ��Դ��
	static int max[][] = new int[5][3]; // �������
	static int allocation[][] = new int[5][3]; // ����
	static int need[][] = new int[5][3]; // ����
	static int request[] = new int[3]; // �������
	Scanner scanner = new Scanner(System.in);
	int thread; // �̺߳�

	// ��ʼ��
	public void getData() {
		System.out.println("������A,B,C������Դ����Ŀ��");
		// ����A,B,C������Դ����
		for (int i = 0; i < 3; i++) {
			available[i] = scanner.nextInt();
		}
		// ������̶�������Դ���������
		for (int i = 0; i < 5; i++) {
			System.out.println("���������" + i + "��A,B,C������Դ���������");
			for (int j = 0; j < 3; j++) {
				max[i][j] = scanner.nextInt();
			}
		}
		// ������̷����������Դ��
		for (int i = 0; i < 5; i++) {
			System.out.println("���������" + i + "�ѷ����A,B,C������Դ��");
			for (int j = 0; j < 3; j++) {
				allocation[i][j] = scanner.nextInt();
			}
		}
		// ������̻���Ҫ��������Դ��
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				need[i][j] = max[i][j] - allocation[i][j];
			}
		}
		// ���¼���available
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 5; j++) {
				available[i] -= allocation[j][i];
			}
		}
	}

	// �û�����Ҫ������Դ���̺߳��������Դ���������ж�
	public void getThread() {
		System.out.println("������������Դ���߳�");
		int thread = scanner.nextInt(); // �߳�
		if (thread < 0 || thread > 4) {
			System.out.println("���̲߳�����,����������");
			getThread();
		} else {
			this.thread = thread;
			System.out.println("�������������Դ(���֣���ĳ����Դ����������0)");
			for (int i = 0; i < 3; i++) {
				request[i] = scanner.nextInt();
			}
			if (request[0] > need[thread][0] || request[1] > need[thread][1] || request[2] > need[thread][2]) {
				System.out.println(thread + "�߳��������Դ��������Ҫ����Դ������������");
				getThread();
			} else {
				if (request[0] > available[0] || request[1] > available[1] || request[2] > available[2]) {
					System.out.println(thread + "�߳��������Դ����ϵͳ��Դ������������");
					getThread();
				}
			}
			changeData(thread);
			if (check(thread)) {
				getThread();
			} else {
				recoverData(thread);
				getThread();
			}

		}
	}

	// thread�߳�������Ӧ����̽�Է�����Դ
	public void changeData(int thread) {
		for (int i = 0; i < 3; i++) {
			// ���µ���ϵͳ��Դ��
			available[i] -= request[i];
			// ��������߳�ӵ����Դ
			allocation[thread][i] += request[i];
			// ���¼�������
			need[thread][i] -= request[i];
		}
	}

	// ��ȫ�Լ��Ϊͨ��������ʧ��ʱ���ã��ָ�ϵͳԭ״
	public void recoverData(int thread) {
		for (int i = 0; i < 3; i++) {
			// ���µ���ϵͳ��Դ��
			available[i] += request[i];
			// ��������߳�ӵ����Դ
			allocation[thread][i] -= request[i];
			// ���¼�������
			need[thread][i] += request[i];
		}
	}

	// ���߳�thread��ȫ�Լ��
	public boolean check(int thread) {
		boolean finish[] = new boolean[5];
		int work[] = new int[3];
		int queue[] = new int[5]; // ���ڴ�Ű�ȫ����
		int k = 0;// ��ȫ�����±�
		int j; // Ҫ�жϵ��߳�
		int i;
		// �Ƿ����ı�־
		for (i = 0; i < 5; i++)
			finish[i] = false;
		j = thread;
		for (i = 0; i < 3; i++) {
			work[i] = available[i];
		}
		while (j < 5) {
			for (i = 0; i < 3; i++) {
				if (finish[j]) {
					j++;
					break;
				} else if (need[j][i] > work[i]) {
					// System.out.println(need[j][i]+"*"+i+work[i]);
					j++;
					break;
				} else if (i == 2) {
					for (int m = 0; m < 3; m++) {
						work[m] += allocation[j][m];
					}
					finish[j] = true;
					queue[k] = j;
					k++;
					j = 0; // ����С�߳��ٿ�ʼ�ж�
				}
			}
		}

		// �ж��Ƿ����ڰ�ȫ״̬
		for (int p = 0; p < 5; p++) {
			if (finish[p] = false) {
				System.out.println("ϵͳ����ȫ����Դ����ʧ��");
				return false;
			}
		}
		System.out.println("��Դ����ɹ�����ȫ����Ϊ��");
		for (int q = 0; q < 5; q++) {
			System.out.println(queue[q]);
		}
		return true;
	}

	// ��ӡneed��available����Ҫʱ����
	public void showData() {
		System.out.println("need");
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 3; j++) {
				System.out.print(need[i][j] + "     ");
			}
		}
		System.out.println("available");
		for (int j = 0; j < 3; j++) {
			System.out.print(available[j] + "     ");
		}
	}

	public static void main(String[] args) {
		Banker bk = new Banker();
		bk.getData();
		bk.getThread();

	}

}