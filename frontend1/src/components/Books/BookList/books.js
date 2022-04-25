import React from "react";
import {Link} from 'react-router-dom';
import ReactPaginate from "react-paginate";


class Books extends React.Component {

    constructor(props) {
        super(props);

        this.state = {
            page: 0,
            size: 3
        }
    }

    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const bookPageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (

            <div className={"container mm-4 mt-5"}>
                <div className={"row"}>
                    <div className={"table-responsive"}>
                        <table className={"table table-striped"}>
                            <thead>
                            <tr>
                                <th scope={"col"}>Name</th>
                                <th scope={"col"}>Category</th>
                                <th scope={"col"}>Author</th>
                                <th scope={"col"}>Available copies</th>
                                <th scope={"col"}></th>
                            </tr>
                            </thead>
                            <tbody>
                            {books}
                            </tbody>
                        </table>

                        <ReactPaginate
                            previousLabel={"Back"}
                            style={{ textDecoration: 'none' }}
                            previousClassName={"page-link"}
                            nextLabel={"Next"}
                            nextClassName={"page-link"}
                            breakLabel={<a href="/#">...</a>}
                            breakClassName={"break-me"}
                            pageClassName={"ml-1 page-link"}
                            pageCount={bookPageCount}
                            marginPagesDisplayed={2}
                            pageRangeDisplayed={5}
                            onPageChange={this.handlePageClick}
                            containerClassName={"pagination m-4 justify-content-center"}
                            activeClassName={"active"}
                        />
                        <div className={"d-flex justify-content-center"}>
                            <Link className={"btn btn-success"} to={"/books/add"}>Add a new book</Link>
                        </div>
                    </div>
                </div>
            </div>
        )
    }

    handlePageClick = (data) => {
        let selected = data.selected;
        this.setState({
            page: selected
        })
    }

    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((term) => {
            return (
                <tr key={props.term.id}>
                    <td scope={"col"}>{props.term.name}</td>
                    <td scope={"col"}>{props.term.category}</td>
                    <td scope={"col"}>{props.term.author.name + " " + props.term.author.surname}</td>
                    <td scope={"col"}>{props.term.availableCopies}</td>
                    <td scope={"col"} className={"text-right"}>
                        <a title={"Delete"} className={"btn btn-danger"}
                           onClick={() => props.onDelete(props.term.id)}>Delete</a> | <a title={"Mark"} className={"btn btn-primary"}
                                                                                         onClick={() => props.markAsTaken(props.term.id)}>Mark</a> | <Link className={"btn btn-info"}
                                                                                                                                                           onClick={() => props.onEdit(props.term.id)}
                                                                                                                                                           to={`/books/edit/${props.term.id}`}>
                        Edit
                    </Link>
                    </td>
                </tr>
            );
        }).filter((book, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }
}


export default Books;