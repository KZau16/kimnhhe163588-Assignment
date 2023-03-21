/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Author;
import model.Book;
import model.Cart;
import model.Category;
import model.Publisher;
import model.Role;
import model.User;

/**
 *
 * @author msi
 */
public class DAO extends DBContext {

    public List<Book> getBooks() {
        List<Book> list = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return list;
    }

    public List<Category> getAllCategory() {
        List<Category> category = new ArrayList<>();
        String sql = "SELECT [category_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Categories]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                category.add(new Category(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return category;
    }

    public List<Book> getLast() {
        List<Book> book = new ArrayList<>();
        String sql = "select top 8 b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id \n"
                + "order by b.book_id desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                book.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return book;

    }

    public List<Book> getBookByCategoryId(String cid) {
        List<Book> getC = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "                p.name as publisher, c.comment, cate.name as genre\n"
                + "                from Books b\n"
                + "                join Publishers p on b.publisher_id = p.publisher_id\n"
                + "                left outer join Comments c on b.comment_id = c.comment_id\n"
                + "                join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "                join Authors a on aow.author_id = a.author_id\n"
                + "                join Book_genre bg on b.book_id = bg.book_id\n"
                + "               join Categories cate on bg.category_id = cate.category_id where cate.category_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                getC.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return getC;
    }

    public List<Author> getAllAuthor() {
        List<Author> author = new ArrayList<>();
        String sql = "SELECT [author_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Authors]";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                author.add(new Author(rs.getInt(1),
                        rs.getString(2)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return author;
    }

    public List<Book> getBookByAuthorId(String cid) {
        List<Book> getA = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id\n"
                + "where a.author_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, cid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                getA.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return getA;
    }

    public Book getBookById(String bid) {
        List<Book> book = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id\n"
                + "where b.book_id = ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, bid);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public List<Book> searchByName(String text) {
        List<Book> searchL = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id\n"
                + "where b.title like ?";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, "%" + text + "%");
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                searchL.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return searchL;
    }

    public User login(String name, String pass) {
        String sql = "SELECT u.username, u.password, u.name, u.gmail, u.phone_number\n"
                + ", u.address, r.name\n"
                + "from Users u join Roles r on u.role_id = r.role_id\n"
                + "where username = ? and password = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }

        } catch (Exception e) {
        }
        return null;
    }

    public User check(String name) {
        String sql = "SELECT u.username, u.password, u.name, u.gmail, u.phone_number\n"
                + ", u.address, r.name\n"
                + "from Users u join Roles r on u.role_id = r.role_id\n"
                + "where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {
        }
        return null;
    }

    public User register(String name, String pass) {
        String sql = "INSERT INTO [dbo].[Users]\n"
                + "           ([username]\n"
                + "           ,[password]\n"
                + "           ,[role_id])\n"
                + "     VALUES\n"
                + "           (?,?,3)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.setString(2, pass);
            st.executeUpdate();

        } catch (Exception e) {
        }
        return null;
    }

    public List<Book> getBookByPrice() {
        List<Book> desc = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id \n"
                + "order by b.price desc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                desc.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return desc;
    }

    public List<Book> getBookByPrice1() {
        List<Book> asc = new ArrayList<>();
        String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id \n"
                + "order by b.price asc";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                asc.add(new Book(rs.getInt(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getInt(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10)));
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return asc;
    }

    public void deleteProduct(String pid) {
        String sql = "DELETE FROM [dbo].[Book_genre]\n"
                + "      WHERE book_id = ?\n"
                + "DELETE FROM dbo.authors_of_works \n"
                + "      where book_id = ?\n"
                + "delete from Books where book_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pid);
            st.setString(2, pid);
            st.setString(3, pid);
            st.executeUpdate();
        } catch (Exception e) {

        }
    }

    public Author checkAuthor(String name) {
        String sql = "SELECT  [author_id]\n"
                + "      ,[name]\n"
                + "  FROM [Assignment].[dbo].[Authors] where name = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Author(rs.getInt(1), name);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void AddAuthor(String name) {
        String sql = "INSERT INTO [dbo].[Authors]\n"
                + "           ([name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public Publisher checkPublisher(String name) {
        String sql = "SELECT [publisher_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Publishers]\n"
                + "  where name like ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Publisher(rs.getInt(1), name);
            }
        } catch (Exception e) {
        }
        return null;
    }

    public void AddPublisher(String name) {
        String sql = "INSERT INTO [dbo].[Publishers]\n"
                + "           ([name])\n"
                + "     VALUES\n"
                + "           (?)";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            st.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void AddBooks(String title, int quality, int price, String des, String image, String pname) {
        String sql = "INSERT INTO [dbo].[Books]\n"
                + "           ([title]\n"
                + "           ,[quantity]\n"
                + "           ,[price]\n"
                + "           ,[description]\n"
                + "           ,[image]\n"
                + "           ,[publisher_id]\n"
                + "           ,[comment_id])\n"
                + "     VALUES\n"
                + "           (?,?,?,?,?,(select publisher_id from Publishers where name like ?), null)";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setInt(2, quality);
            st.setInt(3, price);
            st.setString(4, des);
            st.setString(5, image);
            st.setString(6, pname);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void addAOW(String book, String author) {
        String sql = "INSERT INTO [dbo].[authors_of_works]\n"
                + "           ([author_id]\n"
                + "           ,[book_id])\n"
                + "     VALUES\n"
                + "           ((select author_id from Authors where name like ?)\n"
                + "           ,(select book_id from Books where title like ?))";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, author);
            st.setString(2, book);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void addBg(String book, String category) {
        String sql = "INSERT INTO [dbo].[Book_genre]\n"
                + "           ([category_id]\n"
                + "           ,[book_id])\n"
                + "     VALUES\n"
                + "           ((select category_id from Categories where name like ?)\n"
                + "           ,(select book_id from Books where title like ?))";

        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, category);
            st.setString(2, book);
            st.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e);
        }

    }

    public void editProduct(String title, String author, String image,
            String quantity, String price, String publisher, String description,
            String bid, String cid) {
        String sql = "UPDATE [dbo].[Books]\n"
                + "   SET [title] = ?\n"
                + "      ,[quantity] = ?\n"
                + "      ,[price] = ?\n"
                + "      ,[description] = ?\n"
                + "      ,[image] = ?\n"
                + " WHERE book_id = ?\n"
                + " UPDATE a\n"
                + "   SET a.[name] = ?\n"
                + "   from Authors as a\n"
                + "join authors_of_works aow on a.author_id = aow.author_id\n"
                + "join Books b on aow.book_id = b.book_id where b.book_id = ?\n"
                + "UPDATE p\n"
                + "SET p.[name] = ?\n"
                + " from Publishers p  join Books b on p.publisher_id = b.publisher_id\n"
                + "where b.book_id = ?\n"
                + "UPDATE bg\n"
                + "   SET [category_id] = ?\n"
                + "      ,[book_id] = ?\n"
                + " from Book_genre bg\n"
                + "join Books b on bg.book_id = b.book_id\n"
                + "join Categories c on bg.category_id = c.category_id \n"
                + "where b.book_id = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, title);
            st.setString(2, quantity);
            st.setString(3, price);
            st.setString(4, description);
            st.setString(5, image);
            st.setString(6, bid);
            st.setString(7, author);
            st.setString(8, bid);
            st.setString(9, publisher);
            st.setString(10, bid);
            st.setString(11, cid);
            st.setString(12, bid);
            st.setString(13, bid);
            st.executeUpdate();
        } catch (Exception e) {

        }
    }

    public List<User> getUser() {
        List<User> list = new ArrayList<>();
        String sql = "SELECT u.[username]\n"
                + "      ,u.[password]\n"
                + "      ,u.[name]\n"
                + "      ,u.[gmail]\n"
                + "      ,u.[phone_number]\n"
                + "      ,u.[address]\n"
                + "      ,r.name\n"
                + "  FROM [dbo].[Users] u join Roles r on u.role_id = r.role_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public User getUserById(String name) {
        String sql = "SELECT u.[username]\n"
                + "      ,u.[password]\n"
                + "      ,u.[name]\n"
                + "      ,u.[gmail]\n"
                + "      ,u.[phone_number]\n"
                + "      ,u.[address]\n"
                + "      ,r.name\n"
                + "  FROM [dbo].[Users] u join Roles r on u.role_id = r.role_id\n"
                + "  where username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new User(rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getString(6),
                        rs.getString(7));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public List<Role> getRole() {
        List<Role> list = new ArrayList<>();
        String sql = "select * from Roles";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Role(rs.getInt(1), rs.getString(2)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public void editUser(String uname, String name, String pass, String gmail,
            String pnum, String address, String role) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET [username] = ?\n"
                + "      ,[password] = ?\n"
                + "      ,[name] = ?\n"
                + "      ,[gmail] = ?\n"
                + "      ,[phone_number] = ?\n"
                + "      ,[address] = ?\n"
                + "      ,[role_id] = ?\n"
                + " WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, uname);
            st.setString(2, pass);
            st.setString(3, name);
            st.setString(4, gmail);
            st.setString(5, pnum);
            st.setString(6, address);
            st.setString(7, role);
            st.setString(8, uname);
            st.executeUpdate();

        } catch (Exception e) {

        }
    }

    public int getNumberPage() {
        String sql = "select count(*)\n"
                + "                from Books b\n"
                + "                join Publishers p on b.publisher_id = p.publisher_id\n"
                + "                left outer join Comments c on b.comment_id = c.comment_id\n"
                + "                join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "                join Authors a on aow.author_id = a.author_id\n"
                + "                join Book_genre bg on b.book_id = bg.book_id\n"
                + "               join Categories cate on bg.category_id = cate.category_id";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                int total = rs.getInt(1);
                int countPage = 0;
                countPage = total / 8;
                if (countPage % 8 != 0) {
                    countPage++;
                }
                return countPage;
            }
        } catch (Exception e) {

        }
        return 0;
    }

    public List<Book> getProductByIndex(int index) {
        List<Book> list = new ArrayList<>();
        String sql = "with x as(select ROW_NUMBER() over (order by b.book_id asc) as r ,b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "                p.name as publisher, c.comment, cate.name as genre\n"
                + "                from Books b\n"
                + "                join Publishers p on b.publisher_id = p.publisher_id\n"
                + "                left outer join Comments c on b.comment_id = c.comment_id\n"
                + "                join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "                join Authors a on aow.author_id = a.author_id\n"
                + "                join Book_genre bg on b.book_id = bg.book_id\n"
                + "               join Categories cate on bg.category_id = cate.category_id)\n"
                + "select * from x where r between ?*8-7 and ?*8";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setInt(1, index);
            st.setInt(2, index);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                list.add(new Book(rs.getInt(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getInt(5),
                        rs.getInt(6),
                        rs.getString(7),
                        rs.getString(8),
                        rs.getString(9),
                        rs.getString(10),
                        rs.getString(11)));
            }
        } catch (Exception e) {

        }
        return list;
    }

    public Role getRoleByName(String name) {
        String sql = "SELECT [role_id]\n"
                + "      ,[name]\n"
                + "  FROM [dbo].[Roles] where name = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, name);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                return new Role(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {

        }
        return null;
    }

    public void changePassword(String pass, String username) {
        String sql = "UPDATE [dbo].[Users]\n"
                + "   SET \n"
                + "       [password] = ?\n"
                + " WHERE username = ?";
        try {
            PreparedStatement st = connection.prepareStatement(sql);
            st.setString(1, pass);
            st.setString(2, username);
            st.executeUpdate();
        } catch (Exception e) {
            
        }
    }
    
    public List<Cart> getCartProduct(ArrayList<Cart> cartlist) {
        List<Cart> product = new ArrayList<Cart>();
        try {
            if(cartlist.size() > 0) {
                for (Cart item : cartlist) {
                    String sql = "select b.book_id, b.title, a.name as author, b.quantity, b.price, b.description, b.image,\n"
                + "p.name as publisher, c.comment, cate.name as genre\n"
                + "from Books b\n"
                + "join Publishers p on b.publisher_id = p.publisher_id\n"
                + "left outer join Comments c on b.comment_id = c.comment_id\n"
                + "join authors_of_works  aow on b.book_id = aow.book_id\n"
                + "join Authors a on aow.author_id = a.author_id\n"
                + "join Book_genre bg on b.book_id = bg.book_id\n"
                + "join Categories cate on bg.category_id = cate.category_id\n"
                + "where b.book_id = ?";
                    PreparedStatement st = connection.prepareStatement(sql);
                    st.setInt(1, item.getId());
                    ResultSet rs = st.executeQuery();
                    while(rs.next()) {
                        Cart row = new Cart();
                        row.setId(rs.getInt(1));
                        row.setTitle(rs.getString(2));
                        row.setGenre(rs.getString(10));
                        row.setPrice(rs.getInt(5) * item.getQuantity());
                        row.setQuantity(item.getQuantity());
                        row.setImage(rs.getString(7));
                        product.add(row);
                    }
                    
                    
                }
            }
        } catch (Exception e) {
            
        }
        return product;
    }


    public static void main(String[] args) {
//        try {
//            System.out.println(new DBContext().connection);
//        } catch (Exception e) {
//            System.out.println("e");
//        }
        DAO dao = new DAO();
        List<Book> list = dao.getProductByIndex(1);
        for (Book b : list) {
            System.out.println(b);

        }
    }
}
