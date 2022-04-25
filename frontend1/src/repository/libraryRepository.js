import axios from "../custom-axios/axios";

const LibraryService = {

    fetchAuthors: () => {
        return axios.get("/authors")
    },

    fetchBooks: () => {
        return axios.get("/books")
    },

    getBook: (id) => {
        return axios.get(`/books/${id}`)
    },

    addBook: (name, category, author, availableCopies) => {
        return axios.post("/books/add", {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },

    editBook: (id, name, category, author, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name" : name,
            "category" : category,
            "author" : author,
            "availableCopies" : availableCopies
        });
    },

    markAsTaken: (id) => {
        return axios.put(`/books/mark/${id}`)
    },

    fetchCountries: () => {
        return axios.get("/countries")
    },

    fetchCategories: () => {
        return axios.get("/categories")
    }
}

export default LibraryService;