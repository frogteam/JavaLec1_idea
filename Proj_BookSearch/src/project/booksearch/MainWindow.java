package project.booksearch;

import java.awt.Color;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MainWindow {

	private static Crawler cr = null; // 크롤러 객체
	private static final String DEFAULT_ICON = "img/book-flat.png";
	private static final int ICON_WIDTH = 80;
	private static final int ICON_HEIGHT = 110;
	
	private ImageIcon defaultIcon = null;   // 북 썸네일 이미지 로딩 전까지 보여지게 될 기본 아이콘 이미지
	
	private SearchResult searchResult = null;
	private boolean isCrawlDone = false;  // 크롤링 완료 여부

	private JFrame frame;
	private JTextField tfSearch;
	private JButton btnSearch;
	private JScrollPane scrollPane1, scrollPane2, scrollPane3;
	private JLabel lblDate;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainWindow window = new MainWindow();
					cr = Crawler.getInstance(); // 크롤러 인스턴스 생성
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	} // end main()

	/**
	 * Create the application.
	 */
	public MainWindow() {
		// 기본 북 아이콘  (썸네일 로딩 전까지 표시될 이미지)
		defaultIcon = resizeImage(new ImageIcon(DEFAULT_ICON));
		
		initialize();		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1078, 745);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);

		JMenu mnFile = new JMenu("File");
		menuBar.add(mnFile);

		JMenuItem mntmSave = new JMenuItem("Save");
		mntmSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 데이터 저장하기 
				saveData();
			}
		});
		mnFile.add(mntmSave);
		
		JMenuItem mnuOpen = new JMenuItem("Open");
		mnuOpen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 데이터 불러오기
				loadData();
			}
		});
		mnFile.add(mnuOpen);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(24, 10, 397, 61);
		frame.getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("검색어");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("굴림체", Font.BOLD, 16));
		lblNewLabel.setBounds(12, 10, 74, 41);
		panel.add(lblNewLabel);

		tfSearch = new JTextField();
		tfSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// 검색어 입력후 Enter 를 눌러도 크롤링
				crawlStores(tfSearch.getText().trim()); // 3개 북스토어 크롤링
			}
		});
		tfSearch.setText("자바");
		tfSearch.setBounds(98, 10, 116, 42);
		panel.add(tfSearch);
		tfSearch.setColumns(10);

		btnSearch = new JButton("검색");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// [검색] 버튼을 눌러도 크롤링 시작
				crawlStores(tfSearch.getText().trim()); // 3개 북스토어 크롤링
			}
		});
		btnSearch.setBounds(226, 16, 74, 31);
		panel.add(btnSearch);

		lblDate = new JLabel("");
		lblDate.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		lblDate.setOpaque(true);
		lblDate.setBackground(Color.LIGHT_GRAY);
		lblDate.setBounds(24, 82, 311, 26);
		frame.getContentPane().add(lblDate);

		JLabel lblStore1 = new JLabel("YES24");
		lblStore1.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore1.setOpaque(true);
		lblStore1.setBackground(Color.YELLOW);
		lblStore1.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore1.setBounds(23, 119, 107, 31);
		frame.getContentPane().add(lblStore1);

		scrollPane1 = new JScrollPane();
		scrollPane1.setBounds(24, 170, 309, 450);
		frame.getContentPane().add(scrollPane1);
		
		JLabel lblStore2 = new JLabel("Aladdin");
		lblStore2.setOpaque(true);
		lblStore2.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore2.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore2.setBackground(Color.YELLOW);
		lblStore2.setBounds(347, 119, 107, 31);
		frame.getContentPane().add(lblStore2);
		
		scrollPane2 = new JScrollPane();
		scrollPane2.setBounds(350, 170, 309, 450);
		frame.getContentPane().add(scrollPane2);
		
		JLabel lblStore3 = new JLabel("Interpark");
		lblStore3.setOpaque(true);
		lblStore3.setHorizontalAlignment(SwingConstants.CENTER);
		lblStore3.setFont(new Font("굴림", Font.BOLD, 18));
		lblStore3.setBackground(Color.YELLOW);
		lblStore3.setBounds(666, 119, 107, 31);
		frame.getContentPane().add(lblStore3);
		
		scrollPane3 = new JScrollPane();
		scrollPane3.setBounds(677, 170, 309, 450);
		frame.getContentPane().add(scrollPane3);
	} // end initialize()

	// 3개 BookStore 클롤링
	private void crawlStores(String search) {

		isCrawlDone = false;
		
		Date now = new Date();  // 크롤링 시작일시
		searchResult = new SearchResult(search, now);

		// 크롤링 시작일시 + 검색어 는 화면에 표시
		lblDate.setText(search + " : " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now));

		// 크롤링 시작 : 각각은 개별적인 쓰레드로 진행
		// Yes24
		Thread th1 = new Thread(new Runnable() {
			@Override
			public void run() {
				searchResult.setStoreYes24(cr.crawlStore(search, C.YES24, new OnCompleteListener() {
					// yes24 크롤링 완료후 수행코드
					@Override
					public void complete(InfoStore infoStore) {
						scrollPane1.setViewportView(buildList(infoStore));
					}
				}));
			}
		});
		th1.start();

		// Aladdin
		Thread th2 = new Thread(new Runnable() {
			@Override
			public void run() {
				searchResult.setStoreAladdin(cr.crawlStore(search, C.ALADDIN, new OnCompleteListener() {
					// 크롤링 완료후 수행코드
					@Override
					public void complete(InfoStore infoStore) {
						scrollPane2.setViewportView(buildList(infoStore));
					}
				}));
			}
		});
		th2.start();

		// Interpark
		Thread th3 = new Thread(new Runnable() {
			@Override
			public void run() {
				searchResult.setStoreInterpark(cr.crawlStore(search, C.INTERPARK, new OnCompleteListener() {
					// 크롤링 완료후 수행코드
					@Override
					public void complete(InfoStore infoStore) {
						scrollPane3.setViewportView(buildList(infoStore));
					}
				}));
			}
		});
		th3.start();

		
		// 위 3개 북스토어 크롤링 진행후
		try {
			th1.join();
			th2.join();
			th3.join();
			
			isCrawlDone = true;  // 3개 다 완료후 크롤링 종료
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		// 테스트..
		// 크롤링 결과 -> 파일 저장해보기
		//cr.saveData("data/test.data", searchResult);

		// 파일 --> 읽어오기
		//SearchResult result2 = cr.loadData("data/test.data");

		//System.out.println(result2);

	} // end crawlStores()

	
	// List를 만든다
	private JList<InfoBook> buildList(InfoStore infoStore){
		//System.out.println("buildList 호출");  // 한번만 호출됨...
		DefaultListModel<InfoBook> dlm = new DefaultListModel<InfoBook>();
		// JList 생성!
		JList<InfoBook> list = new JList<InfoBook>(dlm);
		list.setCellRenderer(new ListEntryCellRenderer());


		try {
			// 크롤링 결과에서에서 북 데이터 (InfoBook) 추출하여 ListModel 에 추가
			// 리스트에 추가되는 각각의 데이터를 리스트 엔트리 (list entry) 라함
			for(InfoBook e : infoStore.getList()) {

				// 썸네일 로딩 후 InfoBook 에 추가
				ImageIcon icon = resizeImage(new ImageIcon(ImageIO.read(new URL(e.getImgUrl()))));								
				e.setThumbnail(icon);
				
				dlm.addElement(e);  // ListModel 에  list entry 추가
			} //end for
			
			
			/*
			list.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
				
				@Override
				public void valueChanged(ListSelectionEvent e) {
					
					// 그냥 하면 리스트 아이템 클릭시 두번 호출되는 증상 있다.
					// '누를때' 와 '뗄때' 두번 호출되는 것이다.
					// e.getValueIsAdjusting() 은 '누를때' true 를 리턴하고
					// '뗄때' false를 리턴한다
					//  클릭을 구현하려면 아래와 같이 !e.getValueIsAdjusting() 을 하여
					//  떼어질때 동작하게 하자
					if(!e.getValueIsAdjusting()) {					
						// url 은 아래와 같이 얻어오는거 맞다!
						String url = ((InfoBook)list.getModel().getElementAt(e.getLastIndex())).getUrl();
						//System.out.println("리스트 선택 " + e.getLastIndex() + url);
					}
					
					// ※ 위 이벤트는 커서키로 이동할때도 발생하는 이벤트임!  
					// 따라서 ListSelectionListener 에다가 브라우저 동작 시키는 것은 합당하지 않음
					// 아래의 더블클릭 이벤트에 연동함.
				}
			});
			*/
			
			// 더블 클릭시 브라우저로 오픈
			list.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					JList<InfoBook> l = (JList<InfoBook>)e.getSource();
					if(e.getClickCount() == 2) {  // 더블 클릭이면
						// 리스트 상의 몇번째 index 인지 
						int index = l.locationToIndex(e.getPoint());
						
						// model 에서 index 번째 데이터 ListEntry 불러와서 담겨 있는 url 추출
						String url = ((InfoBook)list.getModel().getElementAt(index)).getUrl();
						//System.out.println("더블클릭 " + index + " " + url);
						
						// 기본 브라우저로 해당 북 상세 페이지 오픈
						// java.awt.Desktop 사용
						// 우선 기본브라우저 존재 여부 체크 한뒤 실행
						if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
							try {
								// url 로 기본브라우저에서 오픈
								Desktop.getDesktop().browse(new URI(url));
							} catch (IOException | URISyntaxException e1) {
								e1.printStackTrace();
							}  
						}
					}				
				}
			});
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	} // end buildList()
	
	
	// ImageIcon 크기 변경하기
	private ImageIcon resizeImage(ImageIcon imageIcon) {
		
		Image img = imageIcon.getImage();    //ImageIcon을 Image로 변환.
		img = img.getScaledInstance(ICON_WIDTH, ICON_HEIGHT, Image.SCALE_SMOOTH);
		return new ImageIcon(img);		
	} // end resizeImage()
	
	
	private void saveData() {
		JFileChooser chooser;   // 파일 대화상자
		if(isCrawlDone) {
			String defaultFileName = new SimpleDateFormat("yyyyMMddhhmmss").format(searchResult.getDate()) + "_" + searchResult.getSearch() + ".crawl";
			//System.out.println(defaultFileName);
			
			// 대화상자 생성
			// 현재 CurrentWorkindDirectory 기준으로 파일 대화상자 생성
			chooser = new JFileChooser(new File(System.getProperty("user.dir")));
			
			chooser.setDialogTitle("결과 저장하기");
			
			// 디폴트 파일명 제시
			chooser.setSelectedFile(new File(new File(System.getProperty("user.dir")), defaultFileName));
			
			
			// 파일 필터 객체 생성및 
			FileNameExtensionFilter filter = new FileNameExtensionFilter("크롤링데이터(*.crawl)", "crawl");
			chooser.setFileFilter(filter);
			
			// 저장하기 대화상자 보이기 
			int ref = chooser.showSaveDialog(null);  
			
			
			if(ref != JFileChooser.APPROVE_OPTION) {  // 파일 선택 안했으면
				JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String filePath = chooser.getSelectedFile().getPath();
			if(!filePath.endsWith(".crawl")) {
				filePath += ".crawl";
			}
				
			// 크롤링 결과 저장하기
			cr.saveData(filePath, searchResult);
			
			JOptionPane.showMessageDialog(null,  "저장 완료", "완료", JOptionPane.PLAIN_MESSAGE);
			
		} else {
			JOptionPane.showMessageDialog(null,  "아직 크롤링 완료 안됨", "경고", JOptionPane.WARNING_MESSAGE);
		}
	} // end saveData()
	
	private void loadData() {
		JFileChooser chooser;   // 파일 대화상자
		chooser = new JFileChooser(new File(System.getProperty("user.dir")));
		chooser.setDialogTitle("불러오기");
		
		// 파일 필터 객체 생성및 
		FileNameExtensionFilter filter = new FileNameExtensionFilter("크롤링데이터(*.crawl)", "crawl");
		chooser.setFileFilter(filter);
		
		// 저장하기 대화상자 보이기 
		int ref = chooser.showOpenDialog(null);  
				
		if(ref != JFileChooser.APPROVE_OPTION) {  // 파일 선택 안했으면
			JOptionPane.showMessageDialog(null,  "파일을 선택하지 않았습니다", "경고", JOptionPane.WARNING_MESSAGE);
			return;
		}
		
		String filePath = chooser.getSelectedFile().getPath();
		//System.out.println(filePath);
		searchResult = cr.loadData(filePath);
		
		// 읽어들인 데이터로 화면 업데이트 하기
		String search = searchResult.getSearch();
		Date now = searchResult.getDate();		
		lblDate.setText(search + " : " + new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(now));
		
		scrollPane1.setViewportView(buildList(searchResult.getStoreYes24()));
		scrollPane2.setViewportView(buildList(searchResult.getStoreAladdin()));
		scrollPane3.setViewportView(buildList(searchResult.getStoreInterpark()));
		
	} // end loadData()
	
} // end class


// ListCellRenderer 객체
// 각 List 아이템들이 보여주기 위한 객체 정의
// JList 의 각 아이템에 보여질 데이터객체는 InfoBook 데이터 (이를 list entry 혹은 list item 이라 함)
class ListEntryCellRenderer extends JLabel implements ListCellRenderer<InfoBook> {

	private static final long serialVersionUID = 1L;

	@Override
	public Component getListCellRendererComponent(JList<? extends InfoBook> list, InfoBook value, int index,
			boolean isSelected, boolean cellHasFocus) {

		// 리스트 아이템의 텍스트와 아이콘 설정
		// 줄바꿈하려면 아래와 같이 <html> 태그를 사용해야 한다..
		setText("<html>" + value.getBookTitle() + "<br>" + (int) value.getPrice() + "원 </html>");
		setIcon(value.getThumbnail());

		if (isSelected) {
			setBackground(list.getSelectionBackground());
			setForeground(list.getSelectionForeground());
		} else {
			setBackground(list.getBackground());
			setForeground(list.getForeground());
		}
		
		
		setEnabled(list.isEnabled());
		setFont(list.getFont());
		setOpaque(true);

		return this;
	}

}

