const updateButton = document.getElementById('edit-button')
if (updateButton) {
    updateButton.addEventListener('click', event => {
        const param = new URLSearchParams(location.search);
        const id = param.get('id');
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;
        fetch(`/api/posts/${id}`, {
            method:'PUT',
            headers: {
                "Content-Type" : "application/json"
            },
            body: JSON.stringify({title, content})
        })
        .then(()=> {
            alert('수정이 완료되었습니다.');
            location.replace('/posts');
        });
    });
}

const deleteButton = document.getElementById('delete-button');
    if (deleteButton) {
        deleteButton.addEventListener('click', event => {
            let id = document.getElementById('post-id').value;
            fetch(`/api/posts/${id}`, {
                method: 'DELETE'
            })
            .then(() => {
                alert('삭제가 완료되었습니다.');
                location.replace('/posts');
            });
        });
    }