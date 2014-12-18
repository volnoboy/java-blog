import static org.junit.Assert.*;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.List;

import com.volnoboy.jb.entity.Item;
import com.volnoboy.jb.exception.RssException;
import com.volnoboy.jb.service.RssService;
import org.junit.Before;
import org.junit.Test;



public class RssServiceTest {

	private RssService rssService;

	@Before
	public void setUp() throws Exception {
		rssService = new RssService();
	}

	@Test
	public void testGetItemsFile() throws RssException {
		List<Item> items = rssService.getItems(new File("test-rss/javavids.xml"));
		assertEquals(10, items.size());
		Item firstItem = items.get(0);
		assertEquals("How to generate web.xml in Eclipse", firstItem.getTitle());
		assertEquals("23 03 2014 10:01:34", new SimpleDateFormat("dd MM yyyy HH:mm:ss").format(firstItem.getPublishedDate()));
	}

}