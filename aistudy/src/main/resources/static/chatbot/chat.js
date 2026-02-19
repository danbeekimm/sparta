document.addEventListener('DOMContentLoaded', () => {
    const chatWindow = document.getElementById('chatWindow');
    const userInput = document.getElementById('userInput');
    const sendBtn = document.getElementById('sendBtn');

    const appendMessage = (text, sender) => {
        const row = document.createElement('div');
        row.className = `message-row ${sender}`;
        row.innerHTML = `<div class="bubble">${text}</div>`;
        chatWindow.appendChild(row);
        chatWindow.scrollTop = chatWindow.scrollHeight; // 부드러운 스크롤 적용됨
    };

    const showLoading = () => {
        const loadingRow = document.createElement('div');
        loadingRow.id = 'loading';
        loadingRow.className = 'message-row ai';
        loadingRow.innerHTML = `
            <div class="bubble typing">
                <div class="dot"></div><div class="dot"></div><div class="dot"></div>
            </div>`;
        chatWindow.appendChild(loadingRow);
        chatWindow.scrollTop = chatWindow.scrollHeight;
        return loadingRow;
    };

    const handleChat = async () => {
        const question = userInput.value.trim();
        if (!question) return;

        // 사용자 메시지 표시
        appendMessage(question, 'user');
        userInput.value = '';

        // 로딩 아이콘 표시
        const loadingIndicator = showLoading();

        try {
            // ChatbotController의 @PostMapping 엔드포인트로 요청
            const response = await fetch('/chatbot', {
                method: 'POST',
                headers: { 'Content-Type': 'application/json' },
                body: JSON.stringify(question)
            });

            if (!response.ok) throw new Error('Network response was not ok');

            const answer = await response.text();

            // 로딩 제거 후 AI 응답 표시
            chatWindow.removeChild(loadingIndicator);
            appendMessage(answer, 'ai');

        } catch (error) {
            console.error('Error:', error);
            chatWindow.removeChild(loadingIndicator);
            appendMessage('죄송합니다. 오류가 발생했습니다.', 'ai');
        }
    };

    sendBtn.addEventListener('click', handleChat);
    userInput.addEventListener('keypress', (e) => {
        if (e.key === 'Enter') handleChat();
    });
});