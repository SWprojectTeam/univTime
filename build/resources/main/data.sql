INSERT INTO POST(title, content, created_at, updated_at) VALUES('제목1', '내용1', NOW(), NOW());
INSERT INTO POST(title, content, created_at, updated_at) VALUES('제목2', '내용2', NOW(), NOW());
INSERT INTO POST(title, content, created_at, updated_at) VALUES('제목3', '내용3', NOW(), NOW());
INSERT INTO POST(title, content, created_at, updated_at) VALUES('제목4', '내용4', NOW(), NOW());

INSERT INTO COMMENTS(post_id, body, name) VALUES (1, '이 글 정말 유익하네요!', '김민수');
INSERT INTO COMMENTS(post_id, body, name) VALUES (2, '좋은 정보 감사합니다!', '박지현');
INSERT INTO COMMENTS(post_id, body, name) VALUES (3, '글을 읽고 많은 걸 배웠어요.', '이준혁');
INSERT INTO COMMENTS(post_id, body, name) VALUES (4, '더 자세한 설명이 있으면 좋겠어요.', '정하영');

INSERT INTO COMMENTS(post_id, body, name) VALUES (1, '재미있게 읽었습니다!', '송예린');
INSERT INTO COMMENTS(post_id, body, name) VALUES (2, '이런 내용이 필요했어요. 감사합니다!', '오세훈');
INSERT INTO COMMENTS(post_id, body, name) VALUES (3, '글을 읽고 궁금한 점이 생겼어요!', '한도윤');
INSERT INTO COMMENTS(post_id, body, name) VALUES (4, '정말 공감이 되는 글이네요.', '배수진');

